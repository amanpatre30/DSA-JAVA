class Solution {

    // Find the maximum package weight
    public int maxWeight(int[] arr){
        int max = Integer.MIN_VALUE;

        for(int num : arr){
            max = Math.max(max, num);
        }

        return max;
    }

    // Find the total weight of all packages
    public int sumOfWeight(int[] arr){
        int sum = 0;

        for(int num : arr){
            sum += num;
        }

        return sum;
    }

    // Calculate how many days are required for a given capacity
    public int noOfDayRequired(int[] weights, int capacity){

        int days = 1;
        int load = 0;

        for(int weight : weights){

            if(load + weight > capacity){
                days++;
                load = weight;
            }
            else{
                load += weight;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int low = maxWeight(weights);
        int high = sumOfWeight(weights);
        int ans = 0;
        while(low <= high){

            int mid = low + (high - low) / 2;

            if(noOfDayRequired(weights, mid) <= days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}