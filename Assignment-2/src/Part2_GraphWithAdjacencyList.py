from typing import Dict, List, Deque, Tuple, Set
from collections import deque
import heapq


class GraphWithAdjacencyList:
    """
    [Graphs - Ex1] Exercise: Implement a graph using adjacency list. You can assume it's an undirected graph.
    """
    def __init__(self):
        self.adjNodes: Dict[int, List[int]] = {}  # directed relation

    def __str__(self):
        return str(self.adjNodes.items())

    def add_node(self, key: int) -> None:
        """
        Adds a new node to the graph.
        """
        if key in self.adjNodes:
            raise ValueError("{} already exists".format(key))
        self.adjNodes[key] = []

    def remove_node(self, key: int) -> None:
        """
        Removes the node from the graph.
        """
        if self.adjNodes[key]:
            raise ValueError("{} has remaining edges {}".format(key, self.adjNodes[key]))
        self.adjNodes.pop(key)

    def add_edge(self, node1: int, node2: int) -> None:
        """
        Adds an edge between node1 and node2
        """
        list1 = self.adjNodes[node1]
        list2 = self.adjNodes[node2]

        if node2 not in list1:
            list1.append(node2)
        if node1 not in list2:
            list2.append(node1)

        self.adjNodes[node2] = list2
        self.adjNodes[node1] = list1

    def remove_edge(self, node1: int, node2: int) -> None:
        """
        Removes an edge between node1 and node2
        """
        list1 = self.adjNodes[node1]
        list2 = self.adjNodes[node2]

        if node2 in list1:
            list1.remove(node2)
        if node1 in list2:
            list2.remove(node1)

        self.adjNodes[node2] = list2
        self.adjNodes[node1] = list1

    def get_adj_nodes(self, key: int) -> List[int]:
        """
        Get nodes that are connected to the node represented by ‘key’.
        """
        return self.adjNodes[key]


    def dfs(self, key: int) -> None:
        """
        [Graphs - Ex2] Exercise: DFS Traversal
        Write a method to perform DFS(int key) traverses DFS starting from key printing each node along the way.

        Depth-First Traversal: A depth-first traversal starts at an arbitrary root node and explores nodes as deep as
        possible along each branch before exploring nodes at the same level.
        """
        stack: List[int] = [key]
        visited: Set[int] = set()

        while stack:
            node = stack.pop()  # dfs
            if node in visited:
                continue
            print(node)
            visited.add(node)
            stack.extend(self.adjNodes[node])

    def bfs(self, key: int):
        """
        [Graphs - Ex3] Exercise: BFS Traversal
        Write a method to perform BFS(int key) traverses BFS  starting from key printing each node along the way.

        Breadth-First Traversal: Comparatively, a breadth-first traversal starts at an arbitrary root node and explores
        all neighboring nodes at the same level before going deeper in the graph.
        """
        queue: Deque[int] = deque()
        queue.append(key)
        visited: Set[int] = set()

        while queue:
            node = queue.popleft()
            if node in visited:
                continue
            print(node)
            visited.add(node)
            queue.extend(self.adjNodes[node])

    def min_number_of_edges(self, node1: int, node2: int) -> int:
        """
        [Graphs - Ex4] Exercise: Minimum number of edges between two nodes of a Graph
        Write a method minNumberOfEdges(int node1, int node2) that returns the minimum number of edges between two nodes.

        Simplified Djikstra's algorithm: all weights are one.
        """
        cost: Dict[int, int] = {}
        heap: List[Tuple[int, int]] = [(0, node1)]

        while heap:
            node_cost, node = heapq.heappop(heap)
            if node in cost:
                continue
            cost[node] = node_cost
            for adjacent_node in self.adjNodes[node]:
                heapq.heappush(heap, (node_cost + 1, adjacent_node))

        return cost[node2]
