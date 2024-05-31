class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<Integer>();

        for(int i : nums) {
            if(set.contains(i)) {
                set.remove(i);
                continue;
            }
            set.add(i);
        }

        Iterator<Integer> iter = set.iterator();
        int index = 0;
        while(iter.hasNext()) {
            ans[index++] = iter.next();
        }

        return ans;
    }
}