package 字符串.time_8_27;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,22:28-22:42
 * @version: 1.0
 */
public class NO_lc551学生出勤记录I {
    public boolean checkRecord(String s) {
        int a = 0;

        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == 'A'){
                a++;
            }
        }
        if (s.charAt(s.length() - 1) == 'A') a++;
        if (a <= 1 && !s.contains("LLL")) return true;
        else return false;
    }
}
