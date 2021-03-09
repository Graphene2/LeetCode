package 字符串.time_8_27;

import java.util.*;

/** 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 9:11
 */
public class YES_lc1408数组中的字符串匹配 {
    // 暴力方法，时间复杂度为O(n2) 其中用到了String.contains
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words,(String x,String y) -> x.length() - y.length());
        for (int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++){
                if (words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
    return ans;
    }
    // 简单方法：遍历两遍
    public static List<String> stringMatching2(String[] words) {
        List<String> ans = new ArrayList<>();
        if (words.length == 0) return ans;
        StringBuilder sb = new StringBuilder();
        for (String e : words){
            sb.append(e + ",");
        }
        for (int i = 0; i < words.length ; i++){
            if (sb.toString().indexOf(words[i]) != sb.toString().lastIndexOf(words[i])){
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"mass","as","hero","superhero"};
        stringMatching2(words);
    }

}
