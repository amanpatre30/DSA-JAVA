class Solution {
    public int search(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        // Continue until search space becomes empty
        while (left <= right) {
            // Find middle element
            int mid = left + (right - left) / 2;
            // Target found
            if (nums[mid] == k) {
                return mid;
            }
            // Check if LEFT HALF is sorted
            if (nums[left] <= nums[mid]) {
                // Target lies inside left sorted half
                if (nums[left] <= k && k <= nums[mid]) {
                    right = mid - 1;
                }
                // Target lies in right half
                else {
                    left = mid + 1;
                }
            }
            // Otherwise RIGHT HALF is sorted
            else {
                // Target lies inside right sorted half
                if (nums[mid] <= k && k <= nums[right]) {
                    left = mid + 1;
                }
                // Target lies in left half
                else {
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}