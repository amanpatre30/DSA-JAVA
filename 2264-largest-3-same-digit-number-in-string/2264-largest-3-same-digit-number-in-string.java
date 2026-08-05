class Solution {
    public String largestGoodInteger(String num) {
        String nums[] = {"999" , "888" , "777" , "666" , "555" , "444" , "333" , "222" , "111" , "000"};
        String ans = "";
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(num.contains(nums[i])){
                ans = nums[i];
            }
        }
        return ans;
    }
}