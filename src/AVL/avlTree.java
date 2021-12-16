package AVL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class avlTree {
    public class Node {
        private Node left, right;
        private int height = 1;
        private int value;

        private Node(int val) {
            this.value = val;
        }
    }

    public int height(Node N) {
        if (N == null) {
            return 0;
        } else return N.height;
    }

    private int getBalance(Node N) {
        if (N == null) {
            return 0;
        } else return height(N.left) - height(N.right);
    }

    //perform rotation and update height
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }


    private Node insert(Node node, int value) {
        if (node == null) {
            return (new Node(value));
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // Left Left case
        if (balance > 1 && value < node.left.value) {
            return rightRotate(node);
        }

        //Left Right case
        if (balance > 1 && value > node.right.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //Right Right case
        if (balance < -1 && value > node.right.value) {
            return leftRotate(node);
        }

        //Left Right caser
        if (balance < -1 && value < node.left.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void print(Node root) {

        if (root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height,
                width = (int) Math.pow(2, height - 1);

        // Preparing variables for loop.
        List<Node> current = new ArrayList<Node>(1),
                next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength * width);
        for (int i = 0; i < maxHalfLength * width; i++)
            sb.append(' ');
        String textBuffer;

        // Iterating through height levels.
        for (int i = 0; i < height; i++) {

            sb.setLength(maxHalfLength * ((int) Math.pow(2, height - 1 - i) - 1));

            // Creating spacer space indicator.
            textBuffer = sb.toString();

            // Print tree node elements
            for (Node n : current) {

                System.out.print(textBuffer);

                if (n == null) {

                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {

                    System.out.printf("(%6d)", n.value);
                    next.add(n.left);
                    next.add(n.right);

                }

                System.out.print(textBuffer);

            }

            System.out.println();
            // Print tree node extensions for next level.
            if (i < height - 1) {

                for (Node n : current) {

                    System.out.print(textBuffer);

                    if (n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s",
                                n.left == null ? " " : "/", n.right == null ? " " : "\\");

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            // Renewing indicators for next run.
            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);

        }
    }
    public static void main(String args[]) {
        avlTree t = new avlTree();
        Node root = null;
        while (true) {
            System.out.println("(1) Insert");
//            System.out.println("(2) Delete");

            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferRead.readLine();

                if (Integer.parseInt(s) == 1) {
                    System.out.print("Value to be inserted: ");
                    root = t.insert(root, Integer.parseInt(bufferRead.readLine()));
                }
//                else if (Integer.parseInt(s) == 2) {
//                    System.out.print("Value to be deleted: ");
//                    root = t.deleteNode(root, Integer.parseInt(bufferRead.readLine()));
//                }
                else {
                    System.out.println("Invalid choice, try again!");
                    continue;
                }

                t.print(root);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}





















































