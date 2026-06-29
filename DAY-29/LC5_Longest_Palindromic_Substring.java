class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // Stores the boundaries of the longest palindromic substring found so far
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            // Case 1: Odd length palindromes (e.g., "aba" centered at 'b')
            int len1 = expand(s, i, i);
            // Case 2: Even length palindromes (e.g., "abba" centered between 'b' and 'b')
            int len2 = expand(s, i, i + 1);
            // Take the maximum length found from the current center
            int len = Math.max(len1, len2);

            // If a longer palindrome is found, update the start and end pointers
            if (len > (end - start)) {
                // Calculate new start index based on the center 'i' and length 'len'
                start = i - (len - 1) / 2;
                // Calculate new end index based on the center 'i' and length 'len'
                end = i + len / 2;
            }
        }
        // Return the final longest substring (end + 1 because substring() is exclusive)
        return s.substring(start, end + 1);
    }

    // Helper method to expand outwards from a given center as long as it forms a palindrome
    private int expand(String s, int left, int right) {
        // Continue expanding while within string bounds and characters match
        while (left >= 0 && right < s.length() && 
               s.charAt(left) == s.charAt(right)) {
            left--;  // Move left pointer outwards
            right++; // Move right pointer outwards
        }
        // Return the length of the valid palindrome found
        // Formula cancels out the extra left-- and right++ from the last failing while loop step
        return right - left - 1;
    }
}
