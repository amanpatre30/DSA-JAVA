class Solution {
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public int countVowelSubstrings(String word) {
        int ans = 0 ;
        int n = word.length();
        for(int i = 0 ; i < n ; i++){
            int freq[] = new int[26];
            for(int j = i ; j < n ; j++){
                char ch = word.charAt(j);
                if(isVowel(ch)){
                    freq[ch - 'a']++;
                    if(freq['a' - 'a'] > 0 && freq['e' - 'a'] > 0 && freq['i' - 'a'] > 0 && freq['o' - 'a'] > 0 && freq['u' - 'a'] > 0){
                        ans++;
                    }
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}