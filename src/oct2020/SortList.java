package oct2020;

public class SortList {

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode listNode = new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(5)))));
        ListNode listNode2 = new ListNode(4, new ListNode(2, new ListNode(3, new ListNode(1))));
        sortList.sortList(listNode);
        sortList.sortList(listNode2);

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;


        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);


        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummyHead = new ListNode(-1), current = dummyHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        current.next = left != null ? left : right;
        return dummyHead.next;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midPlusOne = slow.next;
        //Cut left
        slow.next = null;
        return midPlusOne;
    }

}
