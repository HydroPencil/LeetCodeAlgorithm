class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int evenPointer = 0;
        int oddPointer = 1;

        for (int i : nums) {
            if (i >= 0) {
                ans[evenPointer] = i;
                evenPointer += 2;
            }
            if (i < 0) {
                ans[oddPointer] = i;
                oddPointer += 2;
            }
        }

        return ans;
    }
}