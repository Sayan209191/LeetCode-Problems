class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long reviseNumber = 0;
        long place = 1;
        while(n > 0){
            if(n % 10 != 0){
                int digit = n % 10;
                reviseNumber = (digit * place) + reviseNumber;
                sum += digit;
                place *= 10;
            }
            n = n/10;
        }

        return reviseNumber * sum;
        
    }
}