class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String newWord = String.valueOf(chars);
            if (!map.containsKey(newWord)) {
                map.put(newWord, new ArrayList<String>());
            }
            map.get(newWord).add(word);
        }
        
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }
}

// Notes: hashmap to store patterns 
// use Arrays.sort() & String.valueOf to generate patterns
// TC: O(n * klogk) - k is the average length strings   SC: O(n)

// There are also other method using hashing function that can reach O(k * n) time complexity
// But it is likely to cause collision / overflow
