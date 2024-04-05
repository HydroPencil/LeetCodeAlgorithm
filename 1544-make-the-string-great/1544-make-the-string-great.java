class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(!st.isEmpty() && st.peek() != s.charAt(i) && Character.toUpperCase(st.peek()) == Character.toUpperCase(s.charAt(i))) {
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}