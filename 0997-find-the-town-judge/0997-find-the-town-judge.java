class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] getTrust = new int[n + 1];
        int[] giveTrust = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            giveTrust[trust[i][0]]++;
            getTrust[trust[i][1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (giveTrust[i] == 0 && getTrust[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}