package 字符串.time_8_27;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 14:50-15:18
 */
public class YES_lc1071字符串的最大公因子 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    // 辗转相除法。
    private int gcd(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
}
