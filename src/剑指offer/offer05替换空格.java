package 剑指offer;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-20
 * Time: 16:17
 */
public class offer05替换空格 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char cc : s.toCharArray()) {
            if (cc == ' '){
                sb.append("%20");
            }else {
                sb.append(cc);
            }
        }
        return sb.toString();
    }
}
