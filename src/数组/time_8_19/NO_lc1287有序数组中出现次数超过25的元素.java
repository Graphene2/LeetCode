package 数组.time_8_19;

/**leetcode1287 有序数组中出现次数超过25%的元素
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/19 10:26
 */
public class NO_lc1287有序数组中出现次数超过25的元素 {
    public int findSpecialInteger(int[] arr) {
        int k = arr.length / 4;
        for (int i = 0; i < arr.length - k; i++){
            if (arr[i] == arr[i + k]){
                return arr[i];
            }
        }throw new RuntimeException("出错了！");
    }
}
