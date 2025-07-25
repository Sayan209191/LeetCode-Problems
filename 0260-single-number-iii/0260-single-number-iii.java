class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for(int num: nums) {
            xor ^= num;
        }

        int rightMostSetBit = (xor & (xor - 1)) ^ xor;
        int bucket1 = 0, bucket2 = 0;
        
        for(int num : nums) {
            if((num & rightMostSetBit) != 0) {
                bucket1 ^= num;
            }else {
                bucket2 ^= num;
            }
        }

        return new int[]{bucket1 , bucket2};
    }
}