class Solution {
    public int myAtoi(String s) {
        if (s == null) return 0;
        
        int i = 0;
        int n = s.length();
        
        // 1. Ignore leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // 2. Check for optional sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        
        long result = 0;
        
        // 3. Convert digits to integer and avoid overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
            
            // 4. Handle 32-bit signed integer bounds
            if (result > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        
        return (int) (result * sign);
    }
}
