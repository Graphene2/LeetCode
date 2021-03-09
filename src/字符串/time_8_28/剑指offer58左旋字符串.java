package 字符串.time_8_28;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,12:54
 * @version: 1.0
 */
public class 剑指offer58左旋字符串 {
    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0,n);
        String s2 = s.substring(n,s.length());
        return s2 + s1;
    }
    // 列表遍历拼接：若面试规定不允许使用 切片函数 ，则使用此方法。
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
    // 或者简化代码取余操作
    public String reverseLeftWords3(String s, int n) {
        StringBuilder res = new StringBuilder();
        // 重点来了
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    // 字符串遍历拼接
    public String reverseLeftWords4(String s, int n) {
        String res = "";
        for(int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for(int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }

}
