class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for(int num : nums){
            int digit = num;
            if(num < 10){
                ans.add(digit);
            }else{
                Stack<Integer> stack = new Stack<>();

                while(num > 0){
                    stack.push(num % 10);
                    num = num / 10;
                }

                while(!stack.isEmpty()){
                    ans.add(stack.pop());
                }
            }
        }
        int result[] = new int[ans.size()];
        for(int i =0 ; i < ans.size() ; i++){
            result[i] = ans.get(i);
        }
        return result;
    }
}