package oct2020;


/**
 * 206. Reverse Linked List
 * Easy
 * <p>
 * 5398
 * <p>
 * 101
 * <p>
 * Add to List
 * <p>
 * Share
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        listNode2 = reverseLinkedList.reverse(listNode2);
    }

    public ListNode reverse(ListNode head) {

        //Reverse <<<<<
        ListNode prev = null;

        while (head != null) {
            //pointer
            ListNode nextNode = head.next;
            //Head =  1 x 2 , 3 , 4 ...
            head.next = prev;

            //prev = 1.
            prev = head;

            // 1,3,4,5
            head = nextNode;
        }

        return prev;
    }
}
