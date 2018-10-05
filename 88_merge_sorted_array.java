class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        
        int tail = m + n - 1;
        int endIndex1 = m - 1;
        int endIndex2 = n - 1;
        
        while (endIndex1 >= 0 && endIndex2 >= 0) {
            if (nums1[endIndex1] < nums2[endIndex2]) {
                nums1[tail] = nums2[endIndex2];
                endIndex2--;
            } else {
                nums1[tail] = nums1[endIndex1];
                endIndex1--;
            }
            tail--;
        }
        
        if (endIndex2 >= 0) {
            for (int i = 0; i <= endIndex2; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}

// Notes: Pay attention to when m == 0. In fact, it doesn't need to be specially handled.
