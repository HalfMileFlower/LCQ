class WordDistance {
    
    Map<String, List<Integer>> wordMap;
    public WordDistance(String[] words) {
        wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (wordMap.containsKey(words[i])) {
                wordMap.get(words[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                wordMap.put(words[i], indexList);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> indexList1 = wordMap.get(word1);
        List<Integer> indexList2 = wordMap.get(word2);
        int pointer1 = 0;
        int pointer2 = 0;
        int min = Integer.MAX_VALUE;
        
        while (pointer1 < indexList1.size() && pointer2 < indexList2.size()) {
            int index1 = indexList1.get(pointer1);
            int index2 = indexList2.get(pointer2);
            min = Math.min(min, Math.abs(index1 - index2));
            if (min == 1) {
                return 1;
            }
            if (index1 < index2) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

 // Notes: initialization: use map to store word and index list
 // find shortest: two pointer in the index list, smaller index move next
 // an optimization : min == 1 then return
 // initialize TC: O(n) SC: O(n)
 // find shortest: TC: O(n) SC: O(n) worst-case
 