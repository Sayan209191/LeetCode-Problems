class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> brokenKeys = new HashSet<>();
        int count = 0;

        for (char c : brokenLetters.toCharArray()) {
            brokenKeys.add(c);
        }
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (brokenKeys.contains(c)) {
                    count++;
                    break;
                }
            }
        }

        return words.length - count;
    }
}