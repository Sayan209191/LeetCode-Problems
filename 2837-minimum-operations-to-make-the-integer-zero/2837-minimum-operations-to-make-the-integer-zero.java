class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        if(num1 < num2) return -1; 
        for (int steps = 0; steps <= 60; steps++) {
            long diff = num1 - 1L * num2 * steps;
            int bits = Long.bitCount(diff);
            if (bits <= steps && steps <= diff) {
                return steps;
            }
        }

        return -1;
    }
    // private int countBits(long num) {
    //     int count = 0;
    //     while (num > 0) {
    //         count += num & 1;
    //         num >>= 1;
    //     }
    //     return count;
    // }
}