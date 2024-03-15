class Solution {
    public int[] productExceptSelf(int[] nums) {
        int tmp = 1;
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            ans[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for(int i=nums.length - 1; i>=0; i--) {
            ans[i] *= tmp;
            tmp *= nums[i];
        }
        return ans;
    }
}