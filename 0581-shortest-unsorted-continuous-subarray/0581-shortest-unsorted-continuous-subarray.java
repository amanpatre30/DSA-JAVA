class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();

        int left = n;
        int right = -1;

        // Find left boundary
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int index = stack.pop();
                left = Math.min(left, index);
            }

            stack.push(i);
        }

        stack.clear();

        // Find right boundary
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                right = Math.max(right, index);
            }

            stack.push(i);
        }

        if (right == -1) {
            return 0;
        }

        return right - left + 1;
    }
}