class Solution {
    public boolean hasSameDigits(String s) {
           while (s.length() > 2) {
            StringBuilder newbornString = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int firstDigit = s.charAt(i) - '0';               // Convert char to int
                int secondDigit = s.charAt(i + 1) - '0';          // Convert char to int
                int newDigit = (firstDigit + secondDigit) % 10;   // Calculate new digit
                newbornString.append(newDigit);                   // Append new digit to the new string
            }
            s = newbornString.toString();                         // Update s to the new string
        }
        // Check if the final two digits are the same
        return s.charAt(0) == s.charAt(1);
    }
    
}