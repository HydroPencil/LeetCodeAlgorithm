class Solution {
    public int minimumLength(String s) {
        int pre = 0;
        int suf = s.length() - 1;

        while (pre != suf && pre < suf) {
            if (s.charAt(pre) != s.charAt(suf)) return suf - pre + 1;
            int nextPre = pre + 1;
            int nextSuf = suf - 1;
            while (nextPre < s.length() && s.charAt(nextPre) == s.charAt(pre)) nextPre++;
            while (nextSuf >= 0 && s.charAt(nextSuf) == s.charAt(suf)) nextSuf--;
            pre = nextPre;
            suf = nextSuf;
        }

        if (pre > suf) return 0;

        if (pre == suf) return 1;

        return suf - pre + 1;
    }
}