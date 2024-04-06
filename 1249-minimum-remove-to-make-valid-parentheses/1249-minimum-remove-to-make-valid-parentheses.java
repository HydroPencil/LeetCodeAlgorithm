class Solution {
    public String minRemoveToMakeValid(String s) {
        int check = 0;
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                check++;
            }
            if(s.charAt(i) == ')') {
                if(check > 0) {
                    check--;
                } else {
                    continue;
                }
            }
            st.push(s.charAt(i));
        }

        while(!st.isEmpty()) {
            if(check > 0 && st.peek() == '(') {
                check--;
                st.pop();
                continue;
            }
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}