class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] n = new int[101];
        int ans = 0;
        int max = 0;

        for (int i : nums) {
            n[i]++;
            if (max == n[i]) {
                ans += n[i];
                continue;
            }
            if (max < n[i]) {
                max = n[i];
                ans = n[i];
            }
        }

        return ans;
    }
}