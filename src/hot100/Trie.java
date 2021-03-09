package hot100;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-16
 * Time: 9:55
 */
public class Trie {
    private boolean isEnd = false;
    private Trie[] next = new Trie[26];

    public Trie() {}

    public void insert(String word) {//插入单词
        Trie root = this;
        char[] ww = word.toCharArray();
        for (int i = 0; i < ww.length; i++) {
            if (root.next[ww[i] - 'a'] == null) root.next[ww[i] - 'a'] = new Trie();
            root = root.next[ww[i] - 'a'];
        }
        root.isEnd = true;
    }
    // search
    public boolean search(String word) {//查找单词
        Trie root = this;
        char[] sear = word.toCharArray();
        for (int i = 0; i < sear.length; i++) {
            if (root.next[sear[i] - 'a'] == null) return false;
            root = root.next[sear[i] - 'a'];
        }
        return root.isEnd;
    }
    // prefix
    public boolean startsWith(String prefix) {//查找前缀
        Trie root = this;
        char[] pref = prefix.toCharArray();
        for (int i = 0; i < prefix.length(); i++) {
            if (root.next[pref[i] - 'a'] == null) return false;
            root = root.next[pref[i] - 'a'];
        }
        return true;
    }
}


