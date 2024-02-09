class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] linkIndex = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(linkIndex, -1);
        linkIndex[0] = 0;
        count[0]++;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] > count[i]) {
                        count[i] = count[j];
                        linkIndex[i] = j;
                    }
                }
            }
            count[i]++;
            if (linkIndex[i] == -1) {
                linkIndex[i] = i;
            }
        }

        List<Integer> ans = new LinkedList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> now = new LinkedList<>();

            int index = i;
            while (linkIndex[index] != index) {
                now.add(nums[index]);
                index = linkIndex[index];
            }
            now.add(nums[index]);

            if (now.size() > ans.size()) {
                ans = now;
            }
        }

        return ans;
    }
}