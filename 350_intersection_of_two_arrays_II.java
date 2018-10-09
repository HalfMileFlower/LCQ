class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        List<Integer> resList = new ArrayList<>();
        for (Integer num2 : nums2) {
            if (map.containsKey(num2) && map.get(num2) != 0) {
                resList.add(num2);
                map.put(num2, map.get(num2) - 1);
            }
        }
        
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }
}

// Notes: use a list to store the intersection
// TC: O(2n + m)  SC: O(2n)  (n < m)