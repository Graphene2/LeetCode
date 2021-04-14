package JAVAFORMEETING;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-04-14
 * Time: 15:34
 */
public class Trie {
    private Trie[] children;
    private boolean isWord;
    public Trie(){
        children = new Trie[26];
        isWord = false;
    }
    public void insert(String word){
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean search(String word){
        Trie node = searchPrefix(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix){
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
