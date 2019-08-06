from __future__ import annotations
from typing import Type


class TreeNode:
    data: int = None
    left: TreeNode = None
    right: TreeNode = None

    def __init__(self, data: int, left: TreeNode, right: TreeNode):
        self.data = data
        self.left = left
        self.right = right


class Part1_Tree:
    root: TreeNode = None

    def __init__(self, root):
        self.root = root

    """ 
    [Trees - Ex1] Exercise: Printing a tree
    Implement a method called print() to print the values of the data in all the TreeNodes in a Tree above.
    """
    # Preorder: root left right
    def print_preorder(self, root_node) -> None:
        left_node = root_node.left
        right_node = root_node.right
        if left_node is None and right_node is None:
            print(root_node.data)
        elif left_node is None:
            print(root_node.data)
            self.print_preorder(right_node)
        elif right_node is None:
            print(root_node.data)
            self.print_preorder(left_node)
        elif left_node is not None and right_node is not None:
            print(root_node.data)
            self.print_preorder(left_node)
            self.print_preorder(right_node)

    # Postorder: left right root
    def print_postorder(self, root_node) -> None:
        left_node = root_node.left
        right_node = root_node.right
        if left_node is not None and right_node is not None:
            self.print_postorder(left_node)
            self.print_postorder(right_node)
            print(root_node.data)
        elif left_node is None and right_node is None:
            print(root_node.data)
        elif right_node is None:
            self.print_postorder(left_node)
        elif left_node is None:
            self.print_postorder(right_node)

    # Inorder: left root right
    def print_inorder(self, root_node) -> None:
        left_node = root_node.left
        right_node = root_node.right
        if left_node is None and right_node is None:
            print(root_node.data)
        elif left_node is None:
            print(root_node.data)
            self.print_inorder(right_node)
        elif right_node is None:
            self.print_inorder(left_node)
            print(root_node.data)
        elif left_node is not None and right_node is not None:
            self.print_inorder(left_node)
            print(root_node.data)
            self.print_inorder(right_node)

    def print(self):
        print("preorder: ")
        self.print_preorder(self.root)

        print("postorder: ")
        self.print_postorder(self.root)

        print("inorder: ")
        self.print_inorder(self.root)