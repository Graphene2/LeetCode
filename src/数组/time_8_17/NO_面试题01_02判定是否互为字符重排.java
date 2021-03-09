package 数组.time_8_17;

/**面试题01.02判定是否互为字符重排 题意就是两者字符串中字符都是相同的。 过于简单。不推荐
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/17 14:54
 */
public class NO_面试题01_02判定是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        int[] s1temp = new int[26];
        int[] s2temp = new int[26];
        for (char a:s1.toCharArray()){
            s1temp[a - 'a']++;
        }
        for (char b:s2.toCharArray()){
            s2temp[b - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (s1temp[i] != s2temp[i]){
                return false;
            }
        }return true;
    }
    // 省了一个数组。
    public boolean CheckPermutation2(String s1, String s2) {
        int[] temp = new int[26];

        for (char a:s1.toCharArray()){
            temp[a - 'a']++;
        }
        for (char b:s2.toCharArray()){
            temp[b - 'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (temp[i] != 0){
                return false;
            }
        }return true;
    }
}
