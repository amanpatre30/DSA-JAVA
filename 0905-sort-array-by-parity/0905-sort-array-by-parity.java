class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        int ans[] = new int[n];
        if(nums.length == 1){
            return nums;
        }
        for(int num : nums){
            if(num % 2 == 0){
                evenList.add(num);
            }else{
                oddList.add(num);
            }
        }
        int ind = 0;
        for(int i = 0 ; i < evenList.size() ; i++){
            ans[ind++] = evenList.get(i);
        }

        for(int i = 0 ; i < oddList.size() ; i++){
            ans[ind++] = oddList.get(i);
        }

        return ans;
    }
}