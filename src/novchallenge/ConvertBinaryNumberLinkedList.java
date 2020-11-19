package novchallenge;

public class ConvertBinaryNumberLinkedList {

    public static void main(String[] args) {

    }

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }

        StringBuilder binary = new StringBuilder();

        while (head != null) {
            binary.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(binary.toString(), 2);

    }
}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}