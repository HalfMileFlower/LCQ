class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (Integer num : nums1) {
            if (set.contains(num)) {
                continue;
            } else {
                set.add(num);
            }
        }
        
        for (Integer num2 : nums2) {
            if (set.contains(num2) && !resultSet.contains(num2)) {
                resultSet.add(num2);
            }
        }
        int[] res = new int[resultSet.size()];
        int index = 0;
        for (Integer num : resultSet) {
            res[index++] = num;
        }
        return res;
    }
}

// Notes: HashSet: contains & add & size