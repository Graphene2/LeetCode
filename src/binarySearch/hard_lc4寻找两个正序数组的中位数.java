package binarySearch;

import java.util.Arrays;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-16
 * Time: 15:07-11:57
 */
public class hard_lc4寻找两个正序数组的中位数 {
    // 时间复杂度为 m + n,空间复杂度为 m + n
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merge = new int[m + n];
        System.arraycopy(nums1,0,merge,0,m);
        System.arraycopy(nums2,0,merge,m,n);

        Arrays.sort(merge);
        if (((m + n) & 1) == 1){
            return merge[(m + n - 1) >>> 1];
        }else {
            return (double)(merge[(m + n - 1) >>> 1] + merge[(m + n) >>> 1]) / 2;
        }
    }
    // 维护一个大小为2的数组记录(m-1)/2 和 m/2 这两个数，使得空间复杂度降低至 1;
    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length;
        int medianIndex = (m + n) / 2;
        int count = -1;
        int i = 0, j = 0;
        int[] res = new int[]{0,0};
        while (count < medianIndex){
            count++;
            if (i == m){
                res[count % 2] = nums2[j];
                j++;
            }else if (j == n){
                res[count % 2] = nums1[i];
                i++;
            }else if (nums1[i] < nums2[j]){
                res[count % 2] = nums1[i];
                i++;
            }else {
                res[count % 2] = nums2[j];
                j++;
            }
        }
        if ((m + n) % 2 == 1){
            return res[count % 2];
        }else {
            return (double)(res[0] + res[1]) / 2;
        }
    }

    // 采用二分法寻找中位数。主题思想为排除范围外部分。
    public double findMedianSortedArrays3(int[] nums1, int[] nums2){
        // 让nums1成为较短的那个数组以减少二分法次数。
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length, n = nums2.length;

        int left = 0, right = m;
        int totalLeft = (m + n + 1) / 2;
        while (left < right){
            int i = (left + right) / 2;
            int j = totalLeft - i;
            if (nums2[j - 1] > nums1[i]){
                left = i + 1;
            }else {
                right = i;
            }
        }

        int i = left;
        int j = totalLeft - left;

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];

        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        }else {
            return (double) (Math.max(nums1LeftMax,nums2LeftMax)
                    + Math.min(nums1RightMin,nums2RightMin)) / 2;
        }
    }
}
