class Solution {
    public int lowerBound(int arr[], int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int upperBound(int arr[], int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        Arrays.fill(ans, -1);
        int start = lowerBound(nums, target);
        int end = upperBound(nums, target);
        if (start < nums.length && nums[start] == target) {
            ans[0] = start;
            ans[1] = end;
        }
        return ans;
    }
}