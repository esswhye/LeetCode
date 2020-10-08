package algo.leetcode143;


import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        reorderList(listNode);
    }

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode slow = head, fast = slow.next;
        //fast and fast.next
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode addToStack = slow.next;

        while (addToStack != null) {

            stack.push(addToStack);
            addToStack = addToStack.next;
        }

        slow.next = null;

        ListNode pointer = head;

        while (!stack.isEmpty()) {
            addToStack = stack.pop();
            addToStack.next = pointer.next;
            pointer.next = addToStack;
            if (pointer.next.next != null) {
                pointer = pointer.next.next;
            }
        }
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