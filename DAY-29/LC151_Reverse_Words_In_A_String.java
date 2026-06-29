class Solution {
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip trailing and extra spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            
            // If the pointer goes out of bounds, break out
            if (i < 0) break;

            int end = i;

            // Move left to find the start of the word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Extract the word and append it to our result
            String word = s.substring(i + 1, end + 1);

            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(word);
        }

        return result.toString();
    }
}