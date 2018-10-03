// Brutal force - time limit exceeded

class WordDictionary {

    /** Initialize your data structure here. */
    private Map<String, Integer> map;
    public WordDictionary() {
        map = new HashMap<String, Integer>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        this.map.put(word, 1);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (this.map.containsKey(word)) {
            return true;
        } else {
            if (word.indexOf(".") != -1) {
                // found "." in word
                for (String w : this.map.keySet()) {
                    if (wordEqual(w, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean wordEqual(String wordOrigin, String wordAdded) {
        if (wordOrigin.length() != wordAdded.length()) {
            return false;
        } else {
            char[] charO = wordOrigin.toCharArray();
            char[] charA = wordAdded.toCharArray();
            for (int i = 0; i < wordOrigin.length(); i++) {
                if (charA[i] == '.') {
                    continue;
                }
                if (charA[i] != charO[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */