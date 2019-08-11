from unittest import TestCase
from Part1_BST import Node, BinarySearchTree


class Part1_BST_Test(TestCase):
    def test_insert(self):
        tree_root = Node(16)
        bst = BinarySearchTree(tree_root)
        bst.insert(10)
        bst.insert(7)
        bst.insert(13)
        bst.insert(21)
        bst.insert(18)
        bst.insert(29)
        bst.insert(99)
        print(bst)

    def test_find(self):
        tree_root = Node(16)
        bst = BinarySearchTree(tree_root)
        bst.insert(10)
        bst.insert(7)
        bst.insert(13)
        bst.insert(21)
        bst.insert(18)
        bst.insert(29)
        bst.insert(99)

        assert bst.find(16)
        assert bst.find(10)
        assert bst.find(7)
        assert bst.find(13)
        assert bst.find(21)
        assert bst.find(18)
        assert bst.find(29)
        assert bst.find(99)

        assert not bst.find(20)
        assert not bst.find(10000)
