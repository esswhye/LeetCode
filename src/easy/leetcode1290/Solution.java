package easy.leetcode1290;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(1);
        head.next = second;
        second.next = third;


        int a = 1;
        int b = 0;
        int c = 1;

        System.out.println(getDecimalValue(head));

    }

    public static int getDecimalValue(ListNode head) {

        String concatValue="";
        return Integer.parseInt(recursionList(head,concatValue),2);

    }

    public static String recursionList(ListNode head, String concatValue)
    {
        concatValue += String.valueOf(head.val);
        if(head.next == null)
        {
            return concatValue;
        }
        return recursionList(head.next, concatValue);
    }
}
class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }