class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            set.add(nums[i]);
        }
        for(int j = 1 ;j <= n ; j++){
            if(!set.contains(j)){
                list.add(j);
            }
        }
        return list;
    }
}