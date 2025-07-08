class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int idx1 = 0;
        int idx2 = 0;
        
        while(idx1 < nums1.length && idx2 < nums2.length) {
            if(nums1[idx1] <= nums2[idx2]) {
                list.add(nums1[idx1]);
                idx1++;
            } else {
                list.add(nums2[idx2]);
                idx2++;
            }
        }
        
        while(idx1 < nums1.length) {
            list.add(nums1[idx1]);
            idx1++;
        }
        
        while(idx2 < nums2.length) {
            list.add(nums2[idx2]);
            idx2++;
        }
        
        if(list.size() % 2 == 0) {
            return (double) (list.get(list.size()/2) + list.get((list.size()/2) -1))/2;
        } else {
            return (double) list.get(list.size()/2);
        }
    }
}