class Solution {
    public int upperBound(ArrayList<Integer> candle , int target){
        int left = 0;
        int right = candle.size() - 1;
        int ans = candle.size();

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(candle.get(mid) > target){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }


    public int lowerBound(ArrayList<Integer> candle , int target){
        int left = 0;
        int right = candle.size() - 1;
        int ans = candle.size();

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(candle.get(mid) >= target){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        ArrayList<Integer> candlePosition = new ArrayList<>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '|'){
                candlePosition.add(i);
            }
        }
        int[] prefixSum = new int[n];

        // First element
        if (s.charAt(0) == '*') {
            prefixSum[0] = 1;
        } else {
            prefixSum[0] = 0;
        }

        // Remaining elements
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '*') {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }
        int ans[] = new int[queries.length];

        for(int i = 0 ; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];

            int firstCandle = lowerBound(candlePosition, left);
            int lastCandle = upperBound(candlePosition, right) - 1;


             // No valid candle pair
            if (firstCandle >= candlePosition.size() || lastCandle < 0 || firstCandle > lastCandle) {
                ans[i] = 0;
                continue;
            }
            int leftCandle = candlePosition.get(firstCandle);
            int rightCandle = candlePosition.get(lastCandle);

            // Count plates between candles
            ans[i] = prefixSum[rightCandle] - prefixSum[leftCandle];
        }

        return ans;
    }
}