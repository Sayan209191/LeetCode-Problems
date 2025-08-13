class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // int prefix[] = new int[n];
        int prefix;
        int zero = 0;
        if(nums[0] != 0) {
            // prefix[0] = nums[0];
            prefix = nums[0];
        }
        else {
            zero++;
            // prefix[0] = 1;
            prefix = 1;
        }
        // Calculate Prefix 
        for(int i=1; i<n; i++) {
            if(nums[i] != 0) {
                // prefix[i] = prefix[i-1] * nums[i];
                prefix *= nums[i];
            } else {
                zero++;
                // prefix[i] = prefix[i-1];
            }
        }

        for(int i=0; i<n; i++) {
            int num = nums[i];
            if(num == 0) {
                // If More then 1 - 0 present then prduct will also zero
                if(zero > 1) {
                    nums[i] = 0;
                } else {
                    nums[i] = prefix; //prefix[n-1];
                }
            } else {
                if(zero > 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = prefix/num; //prefix[n-1] / num;
                }
                
            }
        }

        return nums;
    }
}