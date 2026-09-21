/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head, curr = head;
        int i = 1;
        int size = 1;
        while (curr.next != null) {
            curr = curr.next;
            size++;
        }

        curr = head;
        while (i < size - n + 1) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        prev.next = curr.next;
        
        if (i == 1) return head.next;
        return head;
    }
}
