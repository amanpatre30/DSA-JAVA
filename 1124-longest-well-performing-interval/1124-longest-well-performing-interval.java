class Solution {
    public int longestWPI(int[] hours) {

        int length = 0;
        int n = hours.length;

        int arr[] = new int[n];

        // Convert hours into +1 and -1
        for (int i = 0; i < n; i++) {
            if (hours[i] > 8) {
                arr[i] = 1;
            } else {
                arr[i] = -1;
            }
        }

        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            prefixSum += arr[i];

            // If prefixSum > 0,
            // interval from 0 to i is valid
            if (prefixSum > 0) {
                length = i + 1;
            }

            // Store first occurrence only
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }

            // Find an earlier prefixSum which is one less
            if (map.containsKey(prefixSum - 1)) {
                int index = map.get(prefixSum - 1);

                length = Math.max(length, i - index);
            }
        }

        return length;
    }
}