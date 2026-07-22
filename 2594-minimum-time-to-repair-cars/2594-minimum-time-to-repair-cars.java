class Solution {

    // Returns the total number of cars that can be repaired
    // by all mechanics within the given time.
    public long countCarsRepaired(int[] ranks, long time) {
        long totalCars = 0;

        for (int rank : ranks) {
            // From: rank * n^2 <= time
            // => n <= sqrt(time / rank)
            totalCars += (long) Math.sqrt((double) time / rank);
        }

        return totalCars;
    }

    public long repairCars(int[] ranks, int cars) {

        long low = 1;

        // Maximum possible time:
        // Let the slowest scenario happen where the highest-ranked mechanic
        // repairs all the cars alone.
        int maxRank = 0;
        for (int rank : ranks) {
            maxRank = Math.max(maxRank, rank);
        }

        long high = (long) maxRank * cars * cars;

        long answer = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (countCarsRepaired(ranks, mid) >= cars) {
                answer = mid;      // Possible answer
                high = mid - 1;    // Try to find a smaller time
            } else {
                low = mid + 1;     // Need more time
            }
        }

        return answer;
    }
}