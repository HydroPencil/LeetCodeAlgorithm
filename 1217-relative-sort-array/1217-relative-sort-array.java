class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int index = 0;
        for(int i : arr2) {
            for(int j = 0; j<arr1.length; j++) {
                if(arr1[j] != -1 && arr1[j] == i) {
                    ans[index++] = i;
                    arr1[j] = -1;
                }
            }
        }
        Arrays.sort(arr1);

        while(index < arr1.length) {
            ans[index] = arr1[index];
            index++;
        }

        return ans;
    }
}