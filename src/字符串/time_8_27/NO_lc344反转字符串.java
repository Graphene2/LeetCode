package 字符串.time_8_27;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/27 14:47-14:48
 */
public class NO_lc344反转字符串 {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) return;

        int left = 0;
        int right = s.length-1;
        while(left < right){  //奇数个的时候中间元素不动
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }
}
