class Solution {
    public int findMin(int[] nums) {

        // Initialize the starting pointer
        int low = 0;

        // Initialize the ending pointer
        int high = nums.length - 1;

        // Variable to store the minimum element found so far
        int ans = Integer.MAX_VALUE;

        // Continue Binary Search until the search space becomes empty
        while (low <= high) {

            // Find the middle index
            int mid = low + (high - low) / 2;

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {

                // Since the left half is sorted,
                // the leftmost element is the smallest in this half
                ans = Math.min(ans, nums[low]);

                // Ignore the left half and search in the right half
                low = mid + 1;

            } else {

                // Left half is not sorted,
                // so the minimum element lies in this half
                ans = Math.min(ans, nums[mid]);

                // Continue searching in the left half
                high = mid - 1;
            }
        }

        // Return the smallest element found
        return ans;
    }
}