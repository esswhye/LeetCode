package dec2020;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointerInNodeII {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(7);

        Node dummy = new Node(0);
        dummy.next = node.left;
        dummy = dummy.next;

        dummy.next = node.right;
        dummy = dummy.next;

        connect2(node);
    }

    public static Node connect2(Node root) {

        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            Node dummy = new Node(0);

            while (size-- > 0) {

                Node node = queue.remove();
                //If access 2nd time it will be in the node(dummy)
                dummy.next = node;
                dummy = dummy.next;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
        }

        return root;
    }

    public static Node connect(Node root) {

        if (root == null) return root;

        Node head = root;

        while (head != null) {
            Node dummy = new Node(0);
            Node temp = dummy;

            while (head != null) {

                if (head.left != null) {
                    //dummy.next will be the next level
                    temp.next = head.left;
                    temp = temp.next;
                }

                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }

                //in the level node to node
                head = head.next;
            }

            //next level
            head = dummy.next;
        }

        return root;
    }
}
