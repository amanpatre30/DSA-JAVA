class Solution {

    public double power(double x , long n){
        // n become 0 in that case we return 1 because if any base to the power is 1 then it is always 1;
        if(n == 0){
            return 1;
        }
        //if power is odd , then seperate the base and set power to even
        if( n % 2 == 1){
            return x * power(x , n - 1);
        }

        return power(x * x , n / 2);
    }

    public double myPow(double x, int n) {
         if (n < 0) {
            // Calculate the power of -n and take reciprocal
            return (1.0 / power(x, -(long)n));
        }

        return power(x , (long)n);
    }
}