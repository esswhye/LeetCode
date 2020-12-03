package dec2020;
/*
Linked List Random Node

Solution
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 */

import java.util.ArrayList;
import java.util.List;

//382
public class LinkedListRandomNode {

    List<Integer> arr = new ArrayList<>();

    public LinkedListRandomNode(ListNode head) {
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return (int) (Math.random() * arr.size());
    }

}
