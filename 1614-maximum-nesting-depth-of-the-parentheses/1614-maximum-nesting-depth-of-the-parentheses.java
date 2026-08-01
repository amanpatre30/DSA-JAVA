class Solution {
    public int maxDepth(String s) {
        int mxDepth = 0;
        int depth = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                depth++;
                mxDepth = Math.max(mxDepth , depth);
            }else if(ch == ')'){
                depth--;
            }
        }
        return mxDepth;
    }
}