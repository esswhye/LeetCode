package LeetcodeAprilChallenge.FirstWeekApirl;
//876. Middle of the Linked List
/*
876. Middle of the Linked List
Easy

1143

55

Add to List

Share
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
 */


public class MiddleOfTheLinkedList {

    ListNode result = new ListNode();

    public static void main(String[] args) {
        MiddleOfTheLinkedList func = new MiddleOfTheLinkedList();
        ListNode node = new ListNode();
        addNoteRecurvesively(node, 0);
        func.middleNode(node);
        System.out.println();
    }

    public ListNode middleNode(ListNode head) {
        int i = findMiddleNode(head, 1);
        getMiddleNode(head, 0, i / 2);
        return result;
    }

    private static void addNoteRecurvesively(ListNode node, int val) {
        if (val == 5) {
            return;
        }

        node.val = val;
        if (val < 4) {
            node.next = new ListNode();
        }
        val++;
        addNoteRecurvesively(node.next, val);
    }

    public int findMiddleNode(ListNode head, int i) {
        if (head == null) {
            return 0;
        }
        return i += findMiddleNode(head.next, i);
    }

    public ListNode getMiddleNode(ListNode head, int i, int stopper) {
        if (i == stopper) {
            result = head;
            return head;
        }
        i++;
        getMiddleNode(head.next, i, stopper);
        return head;
    }

    public ListNode hareAndTortoise(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
