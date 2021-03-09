package 哈希表.time_8_31;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/** 字典序的方法compareTo方法可以调用。 字典树查查学学！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/31 14:42-15:40
 */
public class YES_lc720词典中最长的单词 {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet<>();
        for (String word: words) wordset.add(word);
        for (String word: words) {
            if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0 ){
                boolean flag = true;
                for (int k = 1; k < word.length(); k++){
                    if (!wordset.contains(word.substring(0,k))){
                        flag = false;
                        break;
                    }
                }
                if (flag) ans = word;
            }
        }
        return ans;
    }
    // 方法二：前缀树 + 深度优先搜索
    public String longestWord2(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for (String word: words) {
            trie.insert(word, ++index); //indexed by 1
        }
        trie.words = words;
        return trie.dfs();
    }

}
class Node {
    char c;
    HashMap<Character, Node> children = new HashMap();
    int end;
    public Node(char c){
        this.c = c;
    }
}

class Trie {
    Node root;
    String[] words;
    public Trie() {
        root = new Node('0');
    }

    public void insert(String word, int index) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node(c));
            cur = cur.children.get(c);
        }
        cur.end = index;
    }

    public String dfs() {
        String ans = "";
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node.end > 0 || node == root) {
                if (node != root) {
                    String word = words[node.end - 1];
                    if (word.length() > ans.length() ||
                            word.length() == ans.length() && word.compareTo(ans) < 0) {
                        ans = word;
                    }
                }
                for (Node nei: node.children.values()) {
                    stack.push(nei);
                }
            }
        }
        return ans;
    }
}
