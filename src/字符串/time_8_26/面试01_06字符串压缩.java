package 字符串.time_8_26;

/**面试01_06字符串压缩
 * 和lc38外观序列有相似之处
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/26 12:41-12:51
 */
public class 面试01_06字符串压缩 {
    public String compressString(String S) {
        if (S.length() == 0 || S == null) return S;
        StringBuilder sb = new StringBuilder();
        int  start = 0;
        for (int i = 1; i < S.length() + 1; i++){
            if (i == S.length()){
                sb.append(S.charAt(i)).append(i - start);
            }else if (S.charAt(i) != S.charAt(start)){
                sb.append(S.charAt(start)).append(i - start);
                start = i;
            }
        }
        if (sb.length() >= S.length()) return S;
        else return sb.toString();
    }
}
