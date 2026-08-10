// Definition and Solution class
class Solution {

    // Helper function to expand around a center
    private int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

    // Function to return longest palindromic substring
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        int start = 0, end = 0;

        // Iterate through each index as potential center
        for (int i = 0; i < n; i++) {
            // Odd-length palindrome
            int[] odd = expandAroundCenter(s, i, i);
            // Even-length palindrome
            int[] even = expandAroundCenter(s, i, i + 1);

            // Update longest palindrome
            if (odd[1] - odd[0] > end - start) {
                start = odd[0];
                end = odd[1];
            }
            if (even[1] - even[0] > end - start) {
                start = even[0];
                end = even[1];
            }
        }

        return s.substring(start, end + 1);
    }
}


