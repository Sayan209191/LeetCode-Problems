class Solution {
    public String sortVowels(String s) {
        List<Character> vowelList = new ArrayList<>();
        List<Character> vowel = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for(char ch : s.toCharArray()) {
            if(vowel.contains(ch)) vowelList.add(ch);
        }

        Collections.sort(vowelList);
        int idx = 0;
        char[] res = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            if(vowel.contains(s.charAt(i))) {
                res[i] = vowelList.get(idx);
                idx++;
            } else {
                res[i] = s.charAt(i);
            }
        }
        return new String(res);
    }
}