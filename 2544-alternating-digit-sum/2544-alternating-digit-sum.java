class Solution {
    public int alternateDigitSum(int n) {
        int sum = 0;
        int sign = 1;

        while (n > 0) {
            sum += (n % 10) * sign;
            sign *= -1;
            n /= 10;
        }

        // If the number of digits is even, flip the result
        return sign == 1 ? -sum : sum;
    }
}