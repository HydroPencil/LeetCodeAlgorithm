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
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode ans = head;
        while (head != null && head.next != null) {
            ans = ans.next;
            head = head.next.next;
        }

        return ans;
    }
}