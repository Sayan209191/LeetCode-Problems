class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;

        boolean sign = true;

        if(dividend >= 0 && divisor < 0) sign = false;
        else if(dividend <= 0 && divisor > 0) sign = false;

        long numinator = Math.abs((long)dividend) , denominator = Math.abs((long)divisor);

        int quotient = 0;
        while(numinator >= denominator) {
            int cnt = 0;

            while(numinator >= (denominator << (cnt+1))) {
                cnt++;
            }
            quotient += (1 << cnt);
            numinator -= (denominator << cnt);
        }

        if(quotient == (1 << 31) && sign) return Integer.MAX_VALUE;
        if(quotient == (1 << 31) && !sign) return Integer.MIN_VALUE;

        return sign ? quotient : (-1) * quotient;
    }
}