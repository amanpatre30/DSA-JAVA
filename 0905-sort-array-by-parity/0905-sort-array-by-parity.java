class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Move even numbers to the left and odd numbers to the right
        while (left < right) {

            // Left is odd and right is even -> swap
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            // Move left pointer if current number is even
            if (nums[left] % 2 == 0) {
                left++;
            }

            // Move right pointer if current number is odd
            if (nums[right] % 2 == 1) {
                right--;
            }
        }

        return nums;
    }
}