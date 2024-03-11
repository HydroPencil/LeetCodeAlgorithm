class Solution {
    public String customSortString(String order, String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            while (c[order.charAt(i) - 'a'] != 0) {
                sb.append(order.charAt(i));
                c[order.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < c.length; i++) {
            while (c[i] != 0) {
                sb.append((char) (i + 'a'));
                c[i]--;
            }
        }

        return sb.toString();
    }
}