import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {

        // Edge case: If array is empty, no sequence exists
        if (nums.length == 0) {
            return 0;
        }

        // HashSet is used to:
        // 1. Remove duplicate elements
        // 2. Perform O(1) average time lookup
        Set<Integer> st = new HashSet<>();

        // Store all array elements into the HashSet
        for (int num : nums) {
            st.add(num);
        }

        // Stores the length of the longest consecutive sequence
        int longestSequence = 1;

        // Traverse each unique element in the set
        for (int num : st) {

            // Check whether the current number is the starting point
            // of a consecutive sequence.
            // If (num - 1) exists, then num is not the start.
            if (!st.contains(num - 1)) {

                // Start building the consecutive sequence
                int currentNum = num;
                int currentLength = 1;

                // Continue while the next consecutive number exists
                while (st.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update the maximum sequence length found so far
                longestSequence = Math.max(longestSequence, currentLength);
            }
        }

        // Return the length of the longest consecutive sequence
        return longestSequence;
    }
}