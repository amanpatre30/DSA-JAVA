class Solution {
    public int findPeakElement(int[] arr) {

        int n = arr.length;

        // If there is only one element, it is the peak
        if (n == 1) {
            return 0;
        }

        int low = 1;
        int high = n - 2;

        // Check first element
        if (arr[0] > arr[1]) {
            return 0;
        }

        // Check last element
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Peak found
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Move towards the increasing slope
            if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}