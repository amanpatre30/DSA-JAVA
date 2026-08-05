class Solution {
    public String largestGoodInteger(String num) {
        String nums[] = {"999" , "888" , "777" , "666" , "555" , "444" , "333" , "222" , "111" , "000"};
      
        for(int i = 0 ; i < nums.length ; i++){
            if(num.contains(nums[i])){
               return nums[i];
            }
        }
        return "";
    }
}