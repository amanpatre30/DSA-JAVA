class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        // Check if the first element is the single element
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // Check if the last element is the single element
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        // Ignore first and last elements as they are already checked
        int left = 1;
        int right = n - 2;

        while (left <= right) {

            // Find middle index
            int mid = left + (right - left) / 2;

            // If mid is different from both neighbors,
            // then it is the single element
            if (nums[mid] != nums[mid - 1] &&
                nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Before the single element:
            // Even index -> first occurrence
            // Odd index  -> second occurrence
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {

                // Single element is on the right
                left = mid + 1;
            }
            else {
                // Single element is on the left
                right = mid - 1;
            }
        }

        return -1;
    }
}