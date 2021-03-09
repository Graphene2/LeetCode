package 数组.time_8_15;

/**leetcode717: 1比特与2比特字符 简单题需要把逻辑好好理清楚再去写代码
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/15,19:47
 * @version: 1.0
 */
public class NO_lc717_1比特与2比特字符 {
    public static boolean isOneBitCharacter(int[] bits) {
        int ptr = bits.length - 2;
        int count = 0;
        while (ptr >= 0){
            if (bits[bits.length - 1] == 1) return false;
            if (bits[ptr] == 1){
                count++;
            }
            if (bits[ptr] == 0){
                break;
            }
            ptr--;
        }if (count % 2 == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 0};
        boolean m = isOneBitCharacter(arr);
        System.out.println(m);
    }
}
