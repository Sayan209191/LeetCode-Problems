class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // Upper Bound Algorithms
        int low = 0, high = letters.length - 1;
        int res = high + 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(letters[mid] > target) {
                res = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return res == letters.length ? letters[0] : letters[res];
    }
}