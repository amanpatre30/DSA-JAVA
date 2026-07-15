class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // Stores the maximum product found so far
        int ans = Integer.MIN_VALUE;
        // Prefix product (left → right)
        int pref = 1;
        // Suffix product (right → left)
        int suff = 1;
        for (int i = 0; i < n; i++) {
            // Reset product if it becomes 0
            // (because multiplying further will always remain 0)
            if (pref == 0) {
                pref = 1;
            }
            if (suff == 0) {
                suff = 1;
            }
            // Calculate prefix product
            pref *= nums[i];
            // Calculate suffix product
            suff *= nums[n - i - 1];
            // Update maximum product
            ans = Math.max(ans, Math.max(pref, suff));
        }
        return ans;
    }
}