class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long ans = 0;

        for (int i : nums) {
            ans += i;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (ans - nums[i] <= nums[i]) {
                ans -= nums[i];
            } else {
                break;
            }
        }

        if (ans < nums[0] + nums[1] + nums[2]) return -1;

        return ans;
    }
}