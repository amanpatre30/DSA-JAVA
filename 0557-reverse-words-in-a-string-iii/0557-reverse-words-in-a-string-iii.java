class Solution {
    public String reverseString(String s , int left , int right){
        StringBuilder ans = new StringBuilder();
        while(right >= left){
            ans.append(s.charAt(right));
            right--;
        }

        return ans.toString();
    }
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int start = 0;
        for(int i = 0 ; i <= n ; i++){
            if(i == n || s.charAt(i) == ' '){
                ans.append(reverseString(s , start , i - 1));

                if(i != n){
                    ans.append(' ');
                }

                start = i + 1;
            }
        }

        return ans.toString();
    }
}