class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            map.put(nums[i] , i);
        }
        int m = operations.length;
        for(int i = 0 ; i < m ; i++){
            int old = operations[i][0];
            int newValue = operations[i][1];

            int index = map.get(old);
            nums[index] = newValue;

            map.remove(old);
            
            map.put(newValue , index);
        }

        return nums;
    }
}