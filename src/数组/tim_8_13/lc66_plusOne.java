package 数组.tim_8_13;

/**leetcode66: 加一
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/13 20:47-21:25
 */
public class lc66_plusOne {
    public static int[] plusOne(int[] arr){
        int n = arr.length;
        int[] res = new int[n + 1];
        arr[n - 1] += 1;
        int carry = 0;
        for (int i = n - 1; i >= 0; i--){
            int temp = arr[i]+carry;
            arr[i] = temp % 10;
            carry = temp / 10;
            if (carry == 0) break;
            if (i == 0 && carry == 1){
                for (int j = n - 1; j >= 0; j--){
                    res[j + 1] = arr[j];
                }
                res[0] = 1;
                return res;
            }
        }
        return arr;
    }
    // 判断加一求余数，余数为零继续后一位，余数不为零直接返回。
    public static int[] plusOne2(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--){
            arr[i]++;
            arr[i] = arr[i] % 10;
            if (arr[i] != 0) return arr;
        }
        arr = new int[arr.length + 1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,9,9};
        int[] res = plusOne(arr);
        for (int item:res){
            System.out.print(item+"\t");
        }
    }
}
