class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if (len2 < len1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int left = 0;
        int right = len1;
        int k = (len1 + len2 + 1) / 2;
        
        while (left < right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = k - mid1;
            
            if (nums1[mid1] < nums2[mid2 - 1]) {
                left = mid1 + 1;
            } else {
                right = mid1;
            }
        }
        
        int m1 = left <= 0 ? Integer.MIN_VALUE : nums1[left - 1];
        int m2 = k - left <= 0 ? Integer.MIN_VALUE : nums2[k - left - 1];
        int c1 = Math.max(m1, m2);
        
        if ((len1 + len2) % 2 == 1) {
            return c1 * 1.0;
        }
        
        int n1 = left >= len1 ? Integer.MAX_VALUE : nums1[left];
        int n2 = k - left >= len2 ? Integer.MAX_VALUE : nums2[k - left];
        int c2 = Math.min(n1, n2);
        
        return (c1 + c2) * 0.5;
    }
}

// Notes: basic idea from: https://www.youtube.com/watch?v=KB9IcSCDQ9k
// k = (len1 + len2 + 1) / 2, right of the middle part
// m1 from nums1, m2 from nums2, m1 + m2 = k
// binary search based on nums1[m1] < nums2[m2 - 1], 
// for this question, the implementation of binary search is slightly different from others
// pay attention to the edge case: m1 or m2 == 0 / len1, len2
// TC: O(log(min(m, n)))  SC: O(1)
