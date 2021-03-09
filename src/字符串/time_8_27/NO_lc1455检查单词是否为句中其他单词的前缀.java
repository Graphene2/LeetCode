package 字符串.time_8_27;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,23:17
 * @version: 1.0
 */
public class NO_lc1455检查单词是否为句中其他单词的前缀 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        String[] str = sentence.split(" ");
        for (int i = 0; i < str.length; i++){
            if (str[i].indexOf(searchWord) != -1){
                ans = i + 1;
            }
        }
        return ans;
    }
}
