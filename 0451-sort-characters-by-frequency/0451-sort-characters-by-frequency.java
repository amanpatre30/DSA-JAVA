class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[256];
        for(char ch : s.toCharArray()){
            freq[ch]++;
        }
        List<Character> alpha = new ArrayList<>();
        for(char c = 0 ; c < 256 ; c++){
            if(freq[c] > 0){
                alpha.add(c);
            }
        }
        alpha.sort((a,b) -> freq[b] - freq[a]); // Sort based on frquency;

        StringBuilder result = new StringBuilder();
        for(char c : alpha){
            for(int i = 0 ; i < freq[c] ; i++){
                result.append(c);
            }
        }
        return result.toString();
    }
}