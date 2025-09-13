class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> vowelMap = new HashMap<>();
        Map<Character, Integer> conMap = new HashMap<>();
        int maxiV = 0, maxiC = 0;

        for (char ch : s.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) { 
                int freq = vowelMap.getOrDefault(ch, 0) + 1;
                vowelMap.put(ch, freq);
                maxiV = Math.max(maxiV, freq);
            } else {
                int freq = conMap.getOrDefault(ch, 0) + 1;
                conMap.put(ch, freq);
                maxiC = Math.max(maxiC, freq);
            }
        }

        return maxiV + maxiC;
    }
}
