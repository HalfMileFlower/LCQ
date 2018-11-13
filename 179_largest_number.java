class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = "" + nums[i];
        }
        
        Arrays.sort(strs, new Comparator<String>() {
           public int compare(String s1, String s2) {
               String com1 = s1 + s2;
               String com2 = s2 + s1;
               
               return com2.compareTo(com1);
           } 
        });
        
        if (strs[0].equals("0")) {
            return "0";
        }
        
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            result += strs[i];
        }
        
        return result;
    }
}

// Notes: convert nums to string and use Comparator
// compare based on s2 + s1 compareTo s1 + s2
// Remember to check if strs[0].equals("0")
// TC: O(knlogn) - k is the average lenght of a number  SC: O(n)
