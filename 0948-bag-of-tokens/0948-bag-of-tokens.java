class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans = 0;
        int score = 0;
        int low = 0;
        int high = tokens.length - 1;
        Arrays.sort(tokens);

        while (low <= high) {
            if (power < tokens[low]) {
                if (score <= 0) {
                    break;
                }
                score--;
                power += tokens[high--];
            }
            power -= tokens[low++];
            score++;
            if (score > ans) ans = score;
        }

        return ans;
    }
}