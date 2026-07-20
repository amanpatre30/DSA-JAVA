class Solution {
    public int[] separateDigits(int[] nums) {

        // Stores the final answer
        List<Integer> ans = new ArrayList<>();

        // Traverse every number
        for (int num : nums) {

            // If the number has only one digit
            if (num < 10) {
                ans.add(num);
            } else {

                // Store digits temporarily
                Stack<Integer> stack = new Stack<>();

                // Extract digits from right to left
                while (num > 0) {
                    stack.push(num % 10);
                    num /= 10;
                }

                // Pop to get digits in left-to-right order
                while (!stack.isEmpty()) {
                    ans.add(stack.pop());
                }
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}