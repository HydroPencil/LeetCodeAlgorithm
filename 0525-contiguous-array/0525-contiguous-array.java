class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cur -= 1;
            else cur += 1;

            if (m.containsKey(cur)) {
                max = Math.max(max, i - m.get(cur));
                continue;
            }
            m.put(cur, i);
        }
        return max;
    }
}