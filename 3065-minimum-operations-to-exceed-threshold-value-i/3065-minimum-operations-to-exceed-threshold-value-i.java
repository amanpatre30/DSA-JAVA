class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = n - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < k){
                ans = mid + 1;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}