/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        Stack<Integer> st = new Stack<>();

        if (head.next == null) return true;
        if (head.next.next == null) {
            fast = fast.next;
            return fast.val == head.val;
        }

        while (fast.next != null && fast.next.next != null) {
            st.push(head.val);
            head = head.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            st.push(head.val);
        }

        while (head.next != null && !st.isEmpty()) {
            head = head.next;
            if (head.val != st.pop()) return false;
        }

        return true;
    }
}