package comp;

import comp.task1.Cos;
import comp.task2.SplayTree.Node;

import static comp.task2.SplayTree.insert;
import static comp.task2.SplayTree.printKeys;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        System.out.println(Cos.calc(50));

        System.out.println("\n\nTask 2:");

        Node root = null;
        root = insert(root, 100);
        root = insert(root, 50);
        root = insert(root, 200);
        root = insert(root, 40);
        root = insert(root, 60);
        System.out.println("Preorder traversal of the modified Splay tree:");
        printKeys(root);
    }
}