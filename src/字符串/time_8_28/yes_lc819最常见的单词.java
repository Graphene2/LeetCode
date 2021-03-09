package 字符串.time_8_28;

import java.util.*;


/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,11:19
 * @version: 1.0
 */
public class yes_lc819最常见的单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        //数组转Set
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        set.add("");
        paragraph += ".";
        //结果单词
        String res = " ";
        //最大单词出现次数
        int times = 0;
        //记录单词出现次数的map
        Map<String, Integer> map = new HashMap<>();
        //i,k为双指针
        int i = 0;
        for (int k = 0; k < paragraph.length(); k++) {
            char c = paragraph.charAt(k);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else {
                //利用双指针截取出一个单词
                String word = paragraph.substring(i, k);
                //统一将单词转为小写
                word = word.toLowerCase();
                if (!set.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    //最大值的获取
                    if (map.get(word) > times) {
                        res = word;
                        times = map.get(word);
                    }
                }
                i = k + 1;
            }
        }
        return res;
    }
    // 将
    public String mostCommonWord2(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;
        // 这里采用的截取字符串的方法比较巧妙
        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) { // 通过判断是否是字母来添加到StringBuilder里面，从而截取单词
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }
}
