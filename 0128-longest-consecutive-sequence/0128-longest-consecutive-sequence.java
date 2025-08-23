class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int res = 0;

        for(int num: set){
            if(!set.contains(num-1)){
                int curnum = num;
                int cur = 1;

                while(set.contains(curnum+1)){
                    curnum++;
                    cur++;
                }

                res = Math.max(res, cur);
            }
        }

        return res;
    }
}