package 字符串.time_8_27;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 14:14-14:27
 */
public class 面试题01_09字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s2).indexOf(s1) != -1;
    }
}
