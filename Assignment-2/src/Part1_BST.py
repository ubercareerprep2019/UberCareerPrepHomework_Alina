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
        entry = Node(key)
        current_node = self.root
        parent_node = self.root

        while current_node:
            parent_node = current_node
            assert current_node.key != key
            if current_node.key > key:
                current_node = current_node.left
            elif current_node.key < key:
                current_node = current_node.right

        if parent_node is None:
            self.root = entry
        elif parent_node.key > key:
            parent_node.left = entry
        elif parent_node.key < key:
            parent_node.right = entry

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
