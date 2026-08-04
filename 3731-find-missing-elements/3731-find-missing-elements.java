class Solution {
    public int minElementFunc(int nums[]){
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int num : nums){
            ans = Math.min(num , ans);
        }
        return ans;
    }

    public int maxElementFunc(int nums[]){
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int num : nums){
            ans = Math.max(num , ans);
        }
        return ans;
    }

    public List<Integer> findMissingElements(int[] nums) {
        int minElement = minElementFunc(nums);
        int maxElement = maxElementFunc(nums);
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = minElement ; i < maxElement ; i++){
            if(!map.containsKey(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}