class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int majorityNum = 0;
        int majorityCount = 0;
        int now = Integer.MAX_VALUE;
        int nowCount = 0;

        for (int i : nums) {
            if (i != now) {
                if (majorityCount < nowCount) {
                    majorityNum = now;
                    majorityCount = nowCount;
                }
                now = i;
                nowCount = 0;
            }
            nowCount++;
        }

        if (majorityCount < nowCount) {
            majorityNum = now;
            majorityCount = nowCount;
        }

        return majorityNum;
    }
}