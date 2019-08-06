from unittest import TestCase
from Part1_Tree import Part1_Tree, TreeNode


class Part1_Tree_Test(TestCase):
    def test_print(self):
        left_child = TreeNode(6, None, None)
        right_child = TreeNode(3, None, None)
        left = TreeNode(7, None, None)
        right = TreeNode(17, left_child, right_child)
        root = TreeNode(1, left, right)
        tree = Part1_Tree(root)

        tree.print()
