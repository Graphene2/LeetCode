package 数组.time_8_11;

/**leetcode14: 最长公共前缀 分别找出strs的length和strs.[0]的长度，分别遍历strs.[0]的char与
 * strs其他的string对应位置的char相对比，一旦有不同就输出String。
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/11,20:15
 * @version: 1.0
 */
public class lc14_longestCommonPrefix {
    /**
     * 方法一：纵向遍历
     *      * 时间复杂度：O(mn),m和n分别为字符串数组长度和字符串数组中的字符串的平均长度。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs){
        if (strs == null || strs.length == 0){
            return " ";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i=0; i < length; i++){
            char c = strs[0].charAt(i);
            for (int j=0;j < count;j++){
                if (i == strs[j].length() || c != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    /**
     *方法二： 横向遍历
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i=0 ; i < count; i++){
            prefix = longestCommonPrefix(prefix,strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }return prefix;



    }
    public static String longestCommonPrefix(String s1, String s2){
        int length = Math.min(s1.length(),s2.length());
        int index = 0;
        while (index < length && s1.charAt(index) == s2.charAt(index)){
            index++;
        }
        return s1.substring(0,index);
    }

}
