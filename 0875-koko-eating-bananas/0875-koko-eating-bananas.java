class Solution {

    // Function to find the maximum element in the array
    // This will be the upper bound of the binary search.
    public int maxElement(int[] arr) {

        int maxEl = Integer.MIN_VALUE;

        // Traverse the array to find the largest pile.
        for (int num : arr) {
            maxEl = Math.max(maxEl, num);
        }

        return maxEl;
    }

    // Function to calculate the total hours required
    // if Koko eats 'hourly' bananas per hour.
    public long calculateTotalH(int[] arr, int hourly) {

        long totalH = 0;

        // Calculate hours needed for each pile.
        for (int bananas : arr) {

            // Ceiling division:
            // Example:
            // 7 bananas, speed = 3
            // Hours = (7 + 3 - 1) / 3 = 3
            totalH += (bananas + hourly - 1L) / hourly;
        }

        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {

        // Minimum possible eating speed.
        int low = 1;

        // Maximum possible eating speed.
        int high = maxElement(piles);

        // Store the minimum valid eating speed.
        int ans = high;

        // Binary search on the answer.
        while (low <= high) {

            // Find the middle eating speed.
            int mid = low + (high - low) / 2;

            // Calculate total hours required at this speed.
            long totalH = calculateTotalH(piles, mid);

            // If Koko can finish within h hours,
            // try to find a smaller valid speed.
            if (totalH <= h) {
                ans = mid;
                high = mid - 1;
            } 
            // Otherwise, increase the eating speed.
            else {
                low = mid + 1;
            }
        }

        // Return the minimum eating speed.
        return ans;
    }
}