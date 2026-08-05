class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        int i = 0, n = s.length();
        int sign = 1;
        long num = 0;

        // sign check
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // build number
        while (i < n && Character.isDigit(s.charAt(i))) {
            char ch = s.charAt(i);

            num = num * 10 + (ch - '0');

            // overflow check
            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * num);
    }
}