package 数组.time_8_14;

/**寻找有序数组第一个元素 二分法
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/14,22:12-22:59
 * @version: 1.0
 */
public class YES_erfenfa {
    // 第一个元素，mid 为两者左端，同时mid = target时 high = mid;
    public static int findFirstElement(int[] arr, int target){
        int low = 0, high = arr.length - 1;
        while (low < high){
            int mid = (low + high) / 2;
            if (arr[mid] < target){
                low = mid + 1;
            }else high = mid;
        }
        if (arr[high] == target) return high;
        else return -1;
    }
    // 寻找有序数组最后一个元素 二分法，关键在于修改mid为两者右端，同时在于mid == target时 low = mid；
    public static int findLastElement(int[] arr, int target){
        int low = 0, high = arr.length - 1;
        while (low < high){
            int mid = (low + high) / 2 + 1;
            if (arr[mid] <= target){
                low = mid;
            }else high = mid - 1;
        }
        if (arr[high] == target) return high;
        else return -1;
    }

}
