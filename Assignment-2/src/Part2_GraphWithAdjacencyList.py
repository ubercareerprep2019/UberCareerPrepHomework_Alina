from typing import Dict, List, Deque
from collections import deque

"""
    [Graphs - Ex1] Exercise: Implement a graph using adjacency list. You can assume it's an undirected graph.
"""
class GraphNode:
    data: int
    has_visited: bool
    def __init__(self, data: int):
        self.data = data
        self.has_visited = False

    def __str__(self):
        return str(self.data)

class GraphWithAdjacencyList:
    adjNodes: Dict[GraphNode, List[GraphNode]]

    def __init__(self):
        self.adjNodes = {}

    def __str__(self):
        return self.adjNodes.items()

    """
    Adds a new node to the graph.
    """
    def addNode(self, key: int) -> None:
        vertex = GraphNode(key)
        self.adjNodes.setdefault(vertex, None)

    """
    Removes the node from the graph.
    """
    def removeNode(self, key: int) -> None:
        for vertex, adj_vertices in self.adjNodes.items():
            if vertex.data == key:
                self.adjNodes.pop(vertex)
                return

        raise KeyError

    """
    Adds an edge between node1 and node2
    """
    def addEdge(self, node1: int, node2: int) -> None:
        vertex1 = None
        vertex2 = None

        for vertex, adj_vertices in self.adjNodes.items():
            if vertex.data == node1:
                vertex1 = vertex
            elif vertex.data == node2:
                vertex2 = vertex

        node1_adj_list = self.adjNodes[vertex1]
        node2_adj_list = self.adjNodes[vertex2]
        if node1_adj_list is None:
            self.adjNodes[vertex1] = []
        if node2_adj_list is None:
            self.adjNodes[vertex2] = []

        self.adjNodes[vertex1].append(vertex2)
        self.adjNodes[vertex2].append(vertex1)

    """
    Removes an edge between node1 and node2.
    """
    def removeEdge(self, node1: int, node2: int) -> None:
        if node1 == node2:
            raise Exception("No edge between node1 and node2.")

        for vertex, adj_vertices in self.adjNodes.items():
            if vertex.data == node1:
                for adj_vertex in adj_vertices:
                    if adj_vertex.data == node2:
                        self.adjNodes[vertex].remove(adj_vertex)
            elif vertex.data == node2:
                for adj_vertex in adj_vertices:
                    if adj_vertex.data == node1:
                        self.adjNodes[vertex].remove(adj_vertex)

    """
    Get nodes that are connected to the node represented by ‘key’.
    """
    def getAdjNodes(self, key: int) -> List[GraphNode]:
        for vertex, adj_vertices in self.adjNodes.items():
            if vertex.data == key:
                return adj_vertices

        raise KeyError

    """
    [Graphs - Ex2] Exercise: DFS Traversal
    Write a method to perform DFS(int key) traverses DFS starting from key printing each node along the way. 
    
    Depth-First Traversal: A depth-first traversal starts at an arbitrary root node and explores nodes as deep as 
    possible along each branch before exploring nodes at the same level. 
    """
    def DFS(self, key: int) -> None:
        for vertex in self.adjNodes:
            if vertex.data == key:
                print(vertex)
                vertex.has_visited = True
                self.DFS_helper(vertex)
                return

    def DFS_helper(self, root_vertex: GraphNode) -> None:
        adjacent_vertices = self.adjNodes[root_vertex]

        for vertex in adjacent_vertices:
            if vertex.has_visited == False:
                print(vertex)
                vertex.has_visited = True
                self.DFS_helper(vertex)

    """
    [Graphs - Ex3] Exercise: BFS Traversal
    Write a method to perform BFS(int key) traverses BFS  starting from key printing each node along the way. 
    
    Breadth-First Traversal: Comparatively, a breadth-first traversal starts at an arbitrary root node and explores 
    all neighboring nodes at the same level before going deeper in the graph.
    """
    def BFS(self, key: int):
        queue = deque()

        for vertex in self.adjNodes:
            if vertex.data == key:
                queue.append(vertex)
                vertex.has_visited = True
                while queue:
                    self.BFS_helper(queue.popleft(), queue)
                return

    def BFS_helper(self, root_vertex: GraphNode, queue: Deque[GraphNode]):
        print(root_vertex)
        adjacent_vertices = self.adjNodes[root_vertex]

        for vertex in adjacent_vertices:
            if vertex.has_visited is False:
                queue.append(vertex)
                vertex.has_visited = True


    """
    [Graphs - Ex4] Exercise: Minimum number of edges between two nodes of a Graph
    Write a method minNumberOfEdges(int node1, int node2) that returns the minimum number of edges between two nodes.
    """
    def minNumberOfEdges(self, node1: int, node2: int):


    def minNumberOfEdges_helper(self, ):
