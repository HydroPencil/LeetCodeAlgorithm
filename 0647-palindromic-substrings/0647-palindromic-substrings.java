class Solution {
    public int countSubstrings(String s) {
        int index = 0;
        int ans = 0;

        while (index < s.length()) {
            int target = index + 1;

            while (target < s.length() && s.charAt(index) == s.charAt(target)) {
                target++;
            }

            for (int i = 1; i <= target - index; i++) {
                ans += i;
            }

            int left = index - 1;
            int right = target;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left--) == s.charAt(right++)) {
                    ans++;
                    continue;
                }
                break;
            }

            index = target;
        }

        return ans;
    }
}