package 剑指offer;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-01-22
 * Time: 14:46
 */
public class offer20表示数值的字符串 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        boolean isDot = false, isEore = false, isNum = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') isNum = true;
            else if (str[i] == '.'){
                if (isDot || isEore) return false;
                isDot = true;
            }else if (str[i] == 'e' || str[i] == 'E'){
                if (!isNum || isEore){
                    return false;
                }
                isEore = true;
                isNum = false;
            }
            else if (str[i] == '-' || str[i] == '+'){
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return isNum;
    }
}
