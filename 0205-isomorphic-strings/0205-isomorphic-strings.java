class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sM = new int[200];
        int[] tM = new int[200];
        for(int i=0; i<s.length(); i++){
            if(sM[s.charAt(i)] != tM[t.charAt(i)]) return false;
            sM[s.charAt(i)] = 1 + i ;
            tM[t.charAt(i)] = 1 + i ;
        }
        return true;
    }
}