class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }else{
                nums[i] = 1;
            }
        }

        int countEven = 0;
        int countOdd = 0;
        for(int i = 0 ; i < n ;i++){
            if(nums[i] == 0){
                countEven++;
            }else{
                countOdd++;
            }
        }

        for(int i = 0 ; i < countEven ; i++){
            nums[i] = 0;
        }

        for(int i = countEven ; i < countEven + countOdd ; i++){
            nums[i] = 1;
        }

        return nums;
    }
}