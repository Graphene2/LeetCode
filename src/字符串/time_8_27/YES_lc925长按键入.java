package 字符串.time_8_27;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 10:59-13:05
 */
public class YES_lc925长按键入 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        if (name.charAt(0) != typed.charAt(0)) return false;
        while (i < name.length() && j < typed.length()){
            if (name.charAt(i) == typed.charAt(j)){
                j++;i++;
            }else if (name.charAt(i - 1) != typed.charAt(j) ) return false;
            else {
                j++;
            }
        }
        if (i != name.length()) return false;
        i--;j--;
        while (j < typed.length()){
            if (typed.charAt(j) != name.charAt(i)) return false;
            j++;
        }
        return true;
    }
}
