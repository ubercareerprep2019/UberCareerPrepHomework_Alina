from __future__ import annotations
from Part1_Tree import Part1_Tree, TreeNode

"""
    Node class for BST.
"""
class Node(TreeNode):
    key: int = None
    left: Node = None
    right: Node = None

    def __init__(self, key: int, left: Node = None, right: Node = None):
        self.key = key
        super().__init__(key, left, right)

    def __str__(self):
        return str(self.key)

"""
    [Trees - Ex4] Exercise: Implement a binary search tree
    Implement the insert() and find() methods in the following simple binary search tree class
"""
class BinarySearchTree(Part1_Tree):
    root: Node = None

    def __init__(self, root: Node):
        super().__init__(root)

    """
    Inserts a key into this binary search tree.
    If there are n nodes in a balanced tree, then the average runtime of this method should be log(n).
   
    @param key The key to insert.
    """
    def insert(self, key: int):
        node_to_be_inserted = Node(key)
        current_node = self.root
        if self.root is None:
            self.root = node_to_be_inserted
            return
        elif key == self.root.key:
            raise Exception("Node not added; duplicates not handled.")

        while current_node.left is not None and key < current_node.key:
            current_node = current_node.left
        while current_node.right is not None and key > current_node.key:
            current_node = current_node.right
        if key < current_node.key:
            current_node.left = node_to_be_inserted
        elif key > current_node.key:
            current_node.right = node_to_be_inserted

    """
    Checks whether or not a key exists in this binary search tree.
    If there are n nodes in a balanced tree, then the average runtime of this method should be log(n).
    @param key The key to check for.
    @return true if the key is present in this binary search tree, false otherwise.
    """
    def find(self, key: int) -> bool:
        return self.find_helper(self.root, key)

    """
    Recursive helper find method.
    """
    def find_helper(self, root: Node, key: int) -> bool:
        if root is None:
            return False
        elif root.key == key:
            return True
        elif root.key > key:
            return self.find_helper(root.left, key)
        elif root.key < key:
            return self.find_helper(root.right, key)


    """
    Prints out BST.
    """
    def __str__(self):
        self.print_preorder(self.root)
        return ""
