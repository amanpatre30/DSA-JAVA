class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {

        // HashMap to store:
        // Key   -> Value present in the array
        // Value -> Index of that value in the array
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        // Store every element along with its index
        // Example:
        // nums = [1, 2, 4, 6]
        // map = {1=0, 2=1, 4=2, 6=3}
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int m = operations.length;

        // Process each operation
        for (int i = 0; i < m; i++) {

            // oldValue = value to be replaced
            int oldValue = operations[i][0];

            // newValue = value that will replace oldValue
            int newValue = operations[i][1];

            // Find the index where oldValue is present
            int index = map.get(oldValue);

            // Replace oldValue with newValue in the array
            nums[index] = newValue;

            // Remove the old mapping because oldValue
            // no longer exists in the array
            map.remove(oldValue);

            // Store the new value with the same index
            map.put(newValue, index);
        }

        // Return the updated array
        return nums;
    }
}