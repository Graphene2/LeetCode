package significance.time_Sep;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-09-21
 * Time: 10:09-10:58
 */
public class lc8字符串转换整数 {
    public int myAtoi(String str) {
        str = str.trim();
        // 判断不能进行有效转换的情况
        if (str == null || str.length() == 0) return 0;
        if (!(Character.isDigit(str.charAt(0))
                || str.charAt(0) == '-')
                || str.charAt(0) == '+')
            return 0;
        int ptr = 0;
        int ans = 0;
        while (ptr < str.length()){
            char cc = str.charAt(ptr);
            if (ptr == 0 && (cc == '+' || cc == '-')){
                ptr++;
                continue;
            }
            if (Character.isDigit(cc)){
                int pop = Integer.parseInt(String.valueOf(cc));
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7) )
                    return Integer.MAX_VALUE;
                ans = ans * 10 + pop;
                ptr++;
            }else break;
        }
        if (str.charAt(0) == '-') return -ans;
        else return ans;
    }
    public int myAtoi2(String str){
        int len = str.length();
        char[] charArray = str.toCharArray();
        // 1.去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' '){
            index++;
        }
        // 2.如果遍历已完成，针对极端情况！
        if (index == len) {
            return 0;
        }
        // 3.判断首位符号标志位！
        int flag = 1;
        char firstChar = charArray[index];
        if (firstChar == '-'){
            flag = -1;
            index++;
        }else if (firstChar == '+'){
            index++;
        }
        // 4.将剩余部分存在的数字字符进行转换！
        int ans = 0;
        while (index < len){
            char currChar = charArray[index];
            // 4.1 首先判断不合法的情况
            if (currChar >'9' || currChar < '0'){
                break;
            }
            // 4.2 需要提前判：断乘以 10 以后是否越界
            int pop = currChar - '0';
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7) )
                return Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop > 8))
                return Integer.MIN_VALUE;
            ans = ans * 10 + flag * (pop);
            index++;
        }
        return ans;
    }

}
