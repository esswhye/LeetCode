package novchallenge;

/*
A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list


Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.
 */
public class InsertionSortList {

    public static void main(String[] args) {

        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        InsertionSortList s = new InsertionSortList();

        s.insertionSortList(listNode2);

    }

    public ListNode insertionSortList(ListNode head) {

        ListNode sorted = null;

        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;

           sorted = sortedInsert(current, sorted);

            current = next;


        }
        return sorted;
    }

    public ListNode sortedInsert(ListNode newNode, ListNode sorted) {

        if (sorted == null || sorted.val >= newNode.val) {

            newNode.next = sorted;
            sorted = newNode;

        } else {

            ListNode current = sorted;

            while (current.next != null && current.next.val < newNode.val) {

                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        return sorted;

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
