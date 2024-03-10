class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1[0] > nums2[nums2.length - 1] || nums2[0] > nums1[nums1.length - 1]) return new int[0];
        int i = 0;
        int j = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        Set<Integer> s = new HashSet<>();

        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                s.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        Iterator<Integer> it = s.iterator();
        int[] ans = new int[s.size()];
        int index = 0;
        while (it.hasNext()) {
            ans[index++] = it.next();
        }

        return ans;
    }
}