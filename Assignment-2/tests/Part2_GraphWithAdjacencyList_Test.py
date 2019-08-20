from unittest import TestCase
from Part2_GraphWithAdjacencyList import GraphWithAdjacencyList


class GraphWithAdjacencyListTest(TestCase):
    def test_add_node_and_remove_node(self):
        graph = GraphWithAdjacencyList()

        graph.add_node(7)
        graph.add_node(4)
        graph.add_node(2)
        graph.add_node(0)
        graph.add_node(6)

        assert not graph.get_adj_nodes(7)
        assert not graph.get_adj_nodes(4)
        assert not graph.get_adj_nodes(2)
        assert not graph.get_adj_nodes(0)
        assert not graph.get_adj_nodes(6)

        graph.remove_node(7)
        try:
            graph.get_adj_nodes(7)
        except KeyError:
            pass
        else:
            assert False


    def test_add_edge_and_remove_edge(self):
        graph = GraphWithAdjacencyList()

        graph.add_node(7)
        graph.add_node(4)
        graph.add_node(2)
        graph.add_node(0)
        graph.add_node(6)

        graph.add_edge(7, 2)
        graph.add_edge(7, 4)
        graph.add_edge(4, 6)
        graph.add_edge(4, 2)
        graph.add_edge(6, 0)
        graph.add_edge(2, 0)

        adjacent_nodes = graph.get_adj_nodes(7)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.get_adj_nodes(4)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.get_adj_nodes(2)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.get_adj_nodes(0)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.get_adj_nodes(6)
        for node in adjacent_nodes:
            print(node)
        print()

        graph.remove_edge(0, 2)
        adjacent_nodes = graph.get_adj_nodes(0)
        for node in adjacent_nodes:
            print(node)
        print()

        adjacent_nodes = graph.get_adj_nodes(2)
        for node in adjacent_nodes:
            print(node)
        print()

    def test_DFS(self):
        graph = GraphWithAdjacencyList()

        graph.add_node(2)
        graph.add_node(0)
        graph.add_node(1)
        graph.add_node(3)

        graph.add_edge(2, 0)
        graph.add_edge(0, 1)
        graph.add_edge(2, 1)
        graph.add_edge(2, 3)

        graph.dfs(2)

    def test_BFS(self):
        graph = GraphWithAdjacencyList()

        graph.add_node(2)
        graph.add_node(0)
        graph.add_node(1)
        graph.add_node(3)

        graph.add_edge(2, 0)
        graph.add_edge(0, 1)
        graph.add_edge(2, 1)
        graph.add_edge(2, 3)

        graph.add_node(4)
        graph.add_node(5)
        graph.add_edge(3, 4)
        graph.add_edge(3, 5)

        graph.add_node(6)
        graph.add_edge(4, 6)

        graph.bfs(2)

    def test_min_number_of_edges(self):
        graph = GraphWithAdjacencyList()

        graph.add_node(3)
        graph.add_node(4)
        graph.add_node(5)
        graph.add_node(6)
        graph.add_node(0)
        graph.add_node(1)
        graph.add_node(2)

        graph.add_edge(3, 4)
        graph.add_edge(4, 5)
        graph.add_edge(4, 6)
        graph.add_edge(0, 4)
        graph.add_edge(0, 2)
        graph.add_edge(0, 1)
        graph.add_edge(1, 2)
        graph.add_edge(5, 2)

        assert graph.min_number_of_edges(1, 5) == 2
        assert graph.min_number_of_edges(6, 1) == 3
