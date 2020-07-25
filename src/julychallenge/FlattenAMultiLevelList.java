package julychallenge;


/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3386/
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own,
and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.


 */
public class FlattenAMultiLevelList {

    public static void main(String[] args) {

        Node node = new Node(5);
        node.next = new Node(4);
        node.child = new Node(2);

        Node result = flatten(node);
        System.out.println("TEST");
    }

    public static Node flattenRec(Node head) {
        Node current = head, tail = head;

        while (current != null) {
            Node child = current.child;
            Node next = current.next;
            if (child != null) {
                Node innerTail = flattenRec(child);
                innerTail.next = next;
                if (next != null)
                    next.prev = innerTail;

                current.next = child;
                child.prev = current;

                current.child = null;
                current = innerTail;

            } else {
                current = next;
            }

            if (current != null) {
                tail = current;
            }
        }
        return tail;
    }

    public static Node flatten(Node head) {

        if (head != null)
            flattenRec(head);

        return head;

    }


}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
