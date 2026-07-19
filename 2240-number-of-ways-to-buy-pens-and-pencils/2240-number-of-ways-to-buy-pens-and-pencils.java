class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        // Stores the total number of valid ways to buy pens and pencils
        long ways = 0;

        // Try buying pens from 0 up to the maximum possible
        for (int pens = 0; pens <= total / cost1; pens++) {

            // Money left after buying the current number of pens
            int remaining = total - pens * cost1;

            // Number of ways to buy pencils with the remaining money:
            // (remaining / cost2) gives the maximum pencils we can buy.
            // +1 includes the case of buying 0 pencils.
            ways += remaining / cost2 + 1;
        }

        // Return the total number of valid combinations
        return ways;
    }
}