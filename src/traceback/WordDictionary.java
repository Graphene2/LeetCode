package traceback;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-22
 * Time: 21:36
 */
class WordDictionary {
    HashMap<Integer, HashSet<String>> map;
    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int n = word.length();
        if (map.containsKey(n)){
            HashSet<String> set = map.get(n);
            set.add(word);
        }else {
            HashSet<String> set = new HashSet<>();
            set.add(word);
            map.put(n,set);
        }

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        HashSet<String> set = map.getOrDefault(word.length(), new HashSet<String>());
        if (set.contains(word)) {
            return true;
        }
        for (String s : set) {
            if (equal(s, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean equal(String s, String word) {
        char[] c1 = s.toCharArray();
        char[] c2 = word.toCharArray();
        int n1 = s.length();
        int n2 = word.length();
        if (n1 != n2) {
            return false;
        }
        for (int i = 0; i < n1; i++) {
            if (c1[i] != c2[i] && c2[i] != '.') {
                return false;
            }
        }
        return true;
    }
}
