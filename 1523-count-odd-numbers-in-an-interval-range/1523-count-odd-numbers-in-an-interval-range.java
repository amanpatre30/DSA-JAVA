class Solution {
    public int countOdds(int low, int high) {
        
        int length = high - low + 1;
        if(length % 2 == 0){
            return length / 2;
        }

        if(low % 2 == 1 || high % 2 == 1){
            return length / 2 + 1;
        }
        
        return length / 2 ;
    }
}