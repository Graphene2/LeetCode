package 数组.time_8_11;

/**leetcode167 : 两数之和2 ：输入数组是有序的。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/11 8:47
 */
public class lc167_TwoSum2 {
    // 采用二分法进行数据的查找，时间复杂度为o(NlogN),空间复杂度为o(N).
    public static int[] TwoSum1(int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{low + 1, high + 1};
                }else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }return new int[]{-1,-1};
    }


    // 采用双指针进行数据的查找，时间为o(N)
    public static int[] TwoSum2(int[] numbers, int target){
        int low = 0, high = numbers.length - 1;
        while (low < high){
            int sum = numbers[low] + numbers[high];
            if (sum == target){
                return new int[]{low + 1, high + 1};
            }else if (sum < target){
                low++;
            }else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
