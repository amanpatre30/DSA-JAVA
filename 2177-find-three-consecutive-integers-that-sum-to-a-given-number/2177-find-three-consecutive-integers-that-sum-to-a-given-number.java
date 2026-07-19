class Solution {
    public long[] sumOfThree(long num) {
        long result[] = new long[3];
        if(num % 3 == 0){
            num = num / 3;
            result[0] = num - 1;
            result[1] = num;
            result[2] = num + 1;
        }else{
            return new long[]{};
        }
        return result;
    }
}