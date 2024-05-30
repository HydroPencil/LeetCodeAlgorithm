class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        
        for(int i=0; i<arr.length-1; i++) {
            int a = arr[i];
            for(int j=i+1; j<arr.length; j++) {
                int b = arr[j];
                for(int k=j; k<arr.length; k++) {
                    if(j != k) b ^= arr[k];

                    if(a == b) ans++;
                }
                a ^= arr[j];
            }
        }

        return ans;
    }
}