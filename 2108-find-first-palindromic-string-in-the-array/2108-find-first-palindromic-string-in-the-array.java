class Solution {
    public String firstPalindrome(String[] words) {

        for (String s : words) {
            if (checkPalindrome(s)) return s;
        }

        return "";
    }

    private boolean checkPalindrome(String word) {
        int half = word.length() / 2;

        if (word.length() % 2 == 0) {
            for (int i = 0; i < half; i++) {
                if (word.charAt(half + i) != word.charAt(half - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i <= half; i++) {
            if (word.charAt(half + i) != word.charAt(half - i)) {
                return false;
            }
        }

        return true;
    }
}