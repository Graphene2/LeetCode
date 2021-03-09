package binarySearch;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-16
 * Time: 10:38
 */
public class lc852山脉数组的峰值索引 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (arr[mid] < arr[mid + 1]){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
