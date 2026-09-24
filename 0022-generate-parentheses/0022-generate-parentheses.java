class Solution {

    public static List<String> recursive(String ans , int open , int close , List<String> list , int n){
        if( open == n && close == n){
            list.add(ans);
        }

        if(open < n){
            recursive(ans + "(" , open + 1  , close , list , n);       
        }
        if(close < open){
            recursive(ans + ")" , open , close + 1 , list , n);
        }
        return list;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int o = 0;
        int c = 0;
        return recursive("" , o , c , list , n);   
    }
}