package julychallenge;


import java.util.Stack;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3386/
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own,
and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

                    [9---10--NULL]
             stack [4---5---6--NULL]
         ^        2^
 1---2---3--- 7---8---

 */
public class FlattenAMultiLevelList {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(3);
        node.next.prev = node;
        node.child = new Node(2);
        node.child.next = new Node(8);
        node.child.next.next = new Node(7);
        node.child.child = new Node(4);
        node.child.child.next = new Node(5);
        node.child.child.next.next = new Node(6);
        //Node result = flatten(node);
        Node result2 = flattenV2(node);
        System.out.println("TEST");

        int a = 5;
        int b = a;
        a = 6;

        System.out.println(a + b);

    }

    /*
    1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

                    [9---10--NULL]
             stack [4---5---6--NULL]
                [3---4---5---6--NULL]
         ^        2^
 1---2---7---8---11---12
     */
    public static Node flattenV2(Node head) {
        if (head == null)
            return null;

        Stack<Node> stack = new Stack<>();
        //Get the first reference pointer
        Node first = head;
        //Inner scope
        while (head != null) {
            if (head.child != null) {
                if (head.next != null)
                    stack.push(head.next);
                head.next = head.child;
                head.next.prev = head;
                head.child = null;
            }
            //reach the end of the linkedlist and child elemnts
            else if (head.next == null && !stack.isEmpty()) {
                head.next = stack.pop();
                head.next.prev = head;
            }
            head = head.next;
        }

        return first;
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
                    //avoid first node null exception
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
