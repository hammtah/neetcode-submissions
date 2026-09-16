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
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode copy = head;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (copy != null) {
            stack.push(copy.val);
            copy = copy.next;
        }
        if (stack.isEmpty()) return null;

        res = new ListNode(stack.peek());
        stack.pop();
        copy = res;

        while(!stack.isEmpty()) {
            copy.next = new ListNode(stack.peek());
            copy = copy.next;
            stack.pop();
        }
        return res;
    }
}
