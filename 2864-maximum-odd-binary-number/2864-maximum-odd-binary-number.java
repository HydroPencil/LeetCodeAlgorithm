class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] c = s.toCharArray();
        int countOne = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1') countOne++;
            c[i] = '0';
        }

        c[c.length - 1] = '1';
        countOne--;

        for (int i = 0; i < countOne; i++) {
            c[i] = '1';
        }

        return new String(c);
    }
}