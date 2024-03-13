class Solution {
    public int pivotInteger(int n) {
        int left = 0;
        int right = n * (n + 1) / 2;

        for (int i = 1; i <= n; i++) {
            left += i;
            if (left == right) return i;
            if (left > right) return -1;
            right -= i;
        }
        return 0;
    }
}