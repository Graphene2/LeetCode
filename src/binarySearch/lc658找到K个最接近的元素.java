package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 第二种方法其实很巧妙的！
 * User: zhangcheng
 * Date: 2020-10-17
 * Time: 12:06-14:44
 */
public class lc658找到K个最接近的元素 {
    // 双指针删除的方法
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0){
            if (x - arr[left] <= arr[right] - x){
                right--;
            }else {
                left++;
            }
            removeNums--;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    // 二分法的关键核心在于寻找区间的左端点的位置。通过比较左右端点到x的距离来判断往哪个方向靠拢
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0, right = size - k; // 确定的区间长度为k+1
        // 找出x的位置,采用二分法
        while (left < right){
            int mid = (left + right) / 2;
            if (x - arr[mid] < arr[mid + k] - x){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
