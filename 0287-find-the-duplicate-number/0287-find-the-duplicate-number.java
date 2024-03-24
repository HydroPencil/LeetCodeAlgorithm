class Solution {
    public int findDuplicate(int[] nums) {
        int[] dup = new int[nums.length+1];
        for(int i : nums) {
            dup[i]++;
            if(dup[i] != 1) return i;
        }
        return 0;
    }
}