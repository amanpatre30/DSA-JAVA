class Solution {
    public int alternateDigitSum(int n) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
    
        while(n > 0){
            stack.push(n % 10);
            n = n / 10;
        }
        int i = 0;
        while(!stack.isEmpty()){
            if(i % 2 == 0){
                sum += stack.pop();
            }else{
                sum += (stack.pop() * (-1));
            }
            i++;
        }
        
        return sum;
    }
}