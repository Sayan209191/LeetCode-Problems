class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) {
            return false;
        }
        boolean isVowel = false;
        boolean isConsonant = false;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(specialChar(ch)) {
                return false;
            }
            if(Character.isDigit(ch)) {
                continue;
            }
            if(vowel(ch)) {
                isVowel = true;
            } else {
                isConsonant = true;
            }
        }
        return isVowel && isConsonant;
    }
    public boolean vowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' ||ch=='I'||ch=='O'||ch=='U';
    }
    public boolean specialChar(char ch) {
        return ch=='@' || ch=='#' || ch=='$';
    }
}