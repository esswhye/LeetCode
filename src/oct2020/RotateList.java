package oct2020;


/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        rotateRight(listNode, 2);

       // ListNode result = swapPairsV2(listNode2);
        ListNode result2 = swapPairs(listNode2);
        System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode helper = helper(head);
        return helper;

    }

    public static ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode back = null;
        if (head.next.next != null) {
            back = head.next.next;
        }
        ListNode front = head;
        head = head.next;
        head.next = front;
        head.next.next = back;
        head.next.next = helper(head.next.next);

        return head;
    }


    public static ListNode swapPairsV2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode temp = head.next; // 2 , 3 ,4
        head.next = head.next.next; //1, 3, 4
        temp.next = head; // 2,1,3,4
        head = temp; //
        head.next.next = swapPairs(head.next.next);
        return head;
    }


    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0)
            return head;

        //Find the tail
        int length = 0;
        ListNode tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        length++;

        //Join tail to head
        tail.next = head;

        //Find cutting point
        //elemt 1,2,3,|4,5|
        //index 0,1,2,|3,4|<< rotate point 2%
        int rotatePoint = length - k % length;


        while (rotatePoint > 0) {
            tail = tail.next;
            rotatePoint--;
        }
        head = tail.next;
        tail.next = null;

        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}