class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (indexes == null || indexes.length == 0 || S == null || S.length() == 0) {
            return S;
        }
        
        StringBuilder builder = new StringBuilder();
        
        Map<Integer, Integer> indexToTargets = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (S.startsWith(sources[i], indexes[i])) {
                indexToTargets.put(indexes[i], i);
            }
        }
        
        int index = 0; 
        while (index < S.length()) {
            if (indexToTargets.containsKey(index)) {
                builder.append(targets[indexToTargets.get(index)]);
                index += sources[indexToTargets.get(index)].length();
            } else {
                builder.append(S.charAt(index));
                index++;
            }
        }
        return builder.toString();
    }
}

// Notes: store the replacable indexes[i] and the index of indexes[i](for finding the source)
// use StringBuilder to build the result
// TC: O(n) SC: O(n)
