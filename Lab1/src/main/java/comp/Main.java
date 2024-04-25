package comp;

import comp.task1.Cos;
import comp.task2.SplayTree;
import comp.task2.SplayTree.Node;

import static comp.task2.SplayTree.insert;
import static comp.task2.SplayTree.getTree;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        System.out.println(Cos.calc(50));
        System.out.println(Cos.calc(-1.23, false));

        System.out.println("\n\nTask 2:");

        Node root = insert(null, new int[]{100, 50, 200, 40, 60});
        System.out.println(STR."Preorder traversal of the modified Splay tree:\n\{getTree(null)}");
        System.out.println(STR."Preorder traversal of the modified Splay tree:\n\{getTree(root)}");
        System.out.println(STR."Preorder traversal of the modified Splay tree:\n\{getTree(null, new int[]{0,0,0,0})}");


        System.out.println("\nTask 3:");

    }
}