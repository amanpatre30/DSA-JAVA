class Solution {

    public int countEven(int num) {
        int count = 0;

        // Check every number from 1 to num
        for (int i = 1; i <= num; i++) {

            int sum = 0;
            int temp = i;

            // Calculate the sum of digits of the current number
            while (temp > 0) {
                sum += temp % 10; // Add the last digit
                temp /= 10;       // Remove the last digit
            }

            // If the digit sum is even, increment the count
            if (sum % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}