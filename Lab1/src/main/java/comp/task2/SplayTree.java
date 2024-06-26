package comp.task2;

import java.util.ArrayList;
import java.util.List;

public class SplayTree {

    public static class Node {
        public int key;
        public Node left, right;

        public static List<Integer> keys;

    }

    private static Node newNode(int key) {
        Node node = new Node();
        node.key = key;
        node.left = node.right = null;
        return node;
    }

    private static Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    private static Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private static Node splay(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (root.key > key) {
            if (root.left == null)
                return root;
            if (root.left.key > key) {
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            }
            else if (root.left.key < key) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }
            return (root.left == null) ? root : rightRotate(root);
        }
        else {
            if (root.right == null)
                return root;
            if (root.right.key > key) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rightRotate(root.right);
            }
            else if (root.right.key < key) {
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            }
            return (root.right == null) ? root : leftRotate(root);
        }
    }

    public static Node insert(Node root, int key) {
        if (root == null)
            return newNode(key);

        root = splay(root, key);

        if (root.key == key)
            return root;

        Node node = newNode(key);
        if (root.key > key) {
            node.right = root;
            node.left = root.left;
            root.left = null;
        }
        else {
            node.left = root;
            node.right = root.right;
            root.right = null;
        }
        return node;
    }

    public static Node insert(Node root, int[] keys) {
        for(int key : keys) {
            root = insert(root, key);
        }
        return root;
    }

    private static void setKeys(Node node) {
        if (node != null) {
            setKeys(node.left);
            Node.keys.add(node.key);
            setKeys(node.right);
        }
    }

    public static String getTree(Node node) {
        Node.keys = new ArrayList<>();
        StringBuilder tree = new StringBuilder();
        setKeys(node);
        for (int key : Node.keys) {
            tree.append(key).append("\n");
        }
        return tree.toString();
    }

    public static String getTree(Node node, int[] keys) {
        Node root = insert(null, keys);
        return getTree(root);
    }
}
