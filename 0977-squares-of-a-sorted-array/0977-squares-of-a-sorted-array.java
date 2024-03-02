class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] answer = new int[nums.length];
        int index = nums.length - 1;
        int sq = 0;

        while (index >= 0) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                sq = nums[left++];
            } else {
                sq = nums[right--];
            }

            answer[index--] = sq * sq;
        }

        return answer;
    }
}