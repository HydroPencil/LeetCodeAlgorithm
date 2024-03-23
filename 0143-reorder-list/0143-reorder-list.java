class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode tmp = head;
        st.push(tmp);
        while (tmp.next != null) {
            tmp = tmp.next;
            st.push(tmp);
        }
        int count = st.size() / 2;
        if (st.size() % 2 == 1) {
            for (int i = 0; i < count; i++) {
                ListNode in = st.pop();
                in.next = head.next;
                head.next = in;
                head = head.next.next;
            }
            head.next = null;
        } else {
            for (int i = 0; i < count - 1; i++) {
                ListNode in = st.pop();
                in.next = head.next;
                head.next = in;
                head = head.next.next;
            }
            ListNode in = st.pop();
            in.next = null;
            head.next = in;
        }
    }
}