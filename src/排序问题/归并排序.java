package 排序问题;

/**
 * Description:归并排序，先分割再排序，分割后对比两个数组，从前往后比较较小值放在前面、
 * User: zhangcheng
 * Date: 2020-11-08
 * Time: 10:18
 */
public class 归并排序 {
    // 7. 归并排序，分为各个子序列，先将子序列有序后慢慢合并
    // 时间O(NlogN),空间O(N)
    // 稳定排序。但是要注意排序条件。

    private static final int INSERT_SORT_THRESHOLD = 7;

    public int[] sortArray (int[] nums){
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums,0,len - 1,temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left <= INSERT_SORT_THRESHOLD){
            insertionSort(nums, left, right);
            return;
        }

        int mid = (right + left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]){
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    /**
     *
     * @param nums 给定数组
     * @param left 能取到
     * @param right 能取到
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums,left, temp, left, right - left + 1);
        int i = left, j = mid + 1;
        for (int k = left; k <= right ; k++) {
            if (i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if (j == right + 1){
                nums[k] = temp[i];
                i++;
            }else if (temp[i] <= temp[j]){ // 这里的 <= 是稳定排序的关键！
                nums[k] = temp[i];
                i++;
            }else{
                nums[k] = temp[j];
                j++;
            }

        }

    }


}