class Solution {

    // Returns the maximum pile size
    public int findMaxCandyPile(int[] candies) {
        int maxPile = Integer.MIN_VALUE;

        for (int pile : candies) {
            maxPile = Math.max(maxPile, pile);
        }

        return maxPile;
    }

    // Returns how many children can receive 'candiesPerChild' candies
    public long countChildrenServed(int[] candies, int candiesPerChild) {
        long childrenServed = 0;

        for (int pile : candies) {
            childrenServed += pile / candiesPerChild;
        }

        return childrenServed;
    }

    public int maximumCandies(int[] candies, long k) {

        int low = 1;
        int high = findMaxCandyPile(candies);

        // If total candies are less than the number of children,
        // it is impossible to give even one candy to each child.
        long totalCandies = 0;

        for (int pile : candies) {
            totalCandies += pile;
        }

        if (totalCandies < k) {
            return 0;
        }

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Check if we can give 'mid' candies to at least k children
            if (countChildrenServed(candies, mid) >= k) {
                answer = mid;      // Valid answer
                low = mid + 1;     // Try to maximize candies per child
            } else {
                high = mid - 1;    // Reduce candies per child
            }
        }

        return answer;
    }
}