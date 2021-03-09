package 字符串.time_8_27;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,21:37
 * @version: 1.0
 */
public class lc686重复叠加字符串匹配 {
    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        String temp = A;
        while (temp.lastIndexOf(B) != -1){
            if (temp.length() - B.length() >= A.length()){
                return -1;
            }
            count++;
            temp += A;
        }
        return count;
    }
}
