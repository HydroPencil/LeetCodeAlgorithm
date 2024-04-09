class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int purposeT = tickets[k];

        for(int i=0; i<tickets.length; i++) {
            if(i <= k) {
                if(tickets[i] <= purposeT) {
                    ans += tickets[i];
                } else {
                    ans += purposeT;
                }
            } else {
                if(tickets[i] < purposeT) {
                    ans += tickets[i];
                } else {
                    ans += purposeT-1;
                }                
            }
        }

        return ans;
    }
}