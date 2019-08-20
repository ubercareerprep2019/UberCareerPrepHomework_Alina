from unittest import TestCase
from Part2_GraphWithAdjacencyList import GraphNode, GraphWithAdjacencyList


class GraphWithAdjacencyListTest(TestCase):
    def test_addNode_and_removeNode(self):
        graph = GraphWithAdjacencyList()

        graph.addNode(7)
        graph.addNode(4)
        graph.addNode(2)
        graph.addNode(0)
        graph.addNode(6)

        assert graph.getAdjNodes(7) is None
        assert graph.getAdjNodes(4) is None
        assert graph.getAdjNodes(2) is None
        assert graph.getAdjNodes(0) is None
        assert graph.getAdjNodes(6) is None

        graph.removeNode(7)
        #assert graph.getAdjNodes(7) == KeyError


    def test_addEdge_and_removeEdge(self):
        graph = GraphWithAdjacencyList()

        graph.addNode(7)
        graph.addNode(4)
        graph.addNode(2)
        graph.addNode(0)
        graph.addNode(6)

        graph.addEdge(7, 2)
        graph.addEdge(7, 4)
        graph.addEdge(4, 6)
        graph.addEdge(4, 2)
        graph.addEdge(6, 0)
        graph.addEdge(2, 0)

        adjacent_nodes = graph.getAdjNodes(7)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.getAdjNodes(4)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.getAdjNodes(2)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.getAdjNodes(0)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.getAdjNodes(6)
        for node in adjacent_nodes:
            print(node)
        print()

        graph.removeEdge(0, 2)
        adjacent_nodes = graph.getAdjNodes(0)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.getAdjNodes(2)
        for node in adjacent_nodes:
            print(node)
        print()

    def test_DFS(self):
        graph = GraphWithAdjacencyList()

        graph.addNode(2)
        graph.addNode(0)
        graph.addNode(1)
        graph.addNode(3)

        graph.addEdge(2, 0)
        graph.addEdge(0, 1)
        graph.addEdge(2, 1)
        graph.addEdge(2, 3)

        graph.DFS(2)

    def test_BFS(self):
        graph = GraphWithAdjacencyList()

        graph.addNode(2)
        graph.addNode(0)
        graph.addNode(1)
        graph.addNode(3)

        graph.addEdge(2, 0)
        graph.addEdge(0, 1)
        graph.addEdge(2, 1)
        graph.addEdge(2, 3)

        graph.addNode(4)
        graph.addNode(5)
        graph.addEdge(3, 4)
        graph.addEdge(3, 5)

        graph.addNode(6)
        graph.addEdge(4, 6)

        graph.BFS(2)