class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        int n = nums1.length;
        int m = nums2.length;

        for(int i = 0 ; i < n ; i++){
            int num = nums1[i];
            for(int j = 0 ; j < m ; j++){
                if(num % (nums2[j] * k) == 0){
                    count++;
                }
            }
        }

        return count;
    }
}