class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) != ch) {
                if(i == word.length()-1) return word;
                else {
                    sb.append(word.charAt(i));
                }
            } else {
                sb.append(word.charAt(i));
                sb.reverse();
                if(i != word.length()-1) {
                    sb.append(word.substring(i+1));
                }
                break;
            }
        }

        return sb.toString();
    }
}