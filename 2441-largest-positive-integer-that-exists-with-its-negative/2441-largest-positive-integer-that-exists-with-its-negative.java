class Solution {
    public int findMaxK(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        int ans = -1;

        for(int i : nums) {
            int value = i;
            int key = Math.abs(i);

            if(m.containsKey(key) && value+m.get(key) == 0) {
                if(key > ans) {
                    ans = key;
                }
            } else {
                m.put(key, value);
            }
        }

        return ans;
    }
}