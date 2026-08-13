class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n + 1];
        int duplicate = 0;
        int missing = 0;
        for(int i = 0 ; i < n ; i++){
            arr[nums[i]]++;
        }

        for(int i = 1 ; i <= n ; i++){
            if(arr[i] > 1){
                duplicate = i;
            }

            if(arr[i] == 0){
                missing = i;
            }
        }

        return new int[]{duplicate , missing};
    }
}