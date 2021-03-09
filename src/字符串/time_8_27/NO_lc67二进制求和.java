package 字符串.time_8_27;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/27,20:52-21:17
 * @version: 1.0
 */
public class NO_lc67二进制求和 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int i = aa.length - 1, j = bb.length - 1, carry = 0;
        while (i >= 0 || j >= 0){
            int tmp_a = i < 0? 0 : aa[i] - '0';
            int tmp_b = j < 0? 0 : bb[j] - '0';
            int tmp = tmp_a + tmp_b + carry;
            sb.append(tmp % 2);
            carry = tmp / 2;
            i--;j--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "1010", s2 = "1011";
        String m =  addBinary(s1,s2);
        System.out.println(m);
    }
}
