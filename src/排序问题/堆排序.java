package 排序问题;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-29
 * Time: 10:17
 */
public class 堆排序 {
    // 堆排序是一种基于树的排序。
    public int[] sortArray(int[] nums){
        int len = nums.length;
        // 将数组整理成堆。
        heapify(nums);
        // 循环不变量：区间 [0, i] 堆有序
        for (int i = len - 1; i >= 1 ;) {
           // 把堆顶元素交换到数组末尾。
            swap(nums, 0 ,i);
            // 逐步减少堆有序的数量。
            i--;
            // 下标 0 位置下沉操作，使得区间[0, i] 堆有序。
            siftDown(nums, 0, i);
        }
        return nums;
    }
    // 每进行完一次下沉操作后都能保证父节点一定比子节点大。
    private void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end){
            int j = 2 * k + 1;
            // 寻找父节点和两个子节点中最大的，并将其数值放到位置k。
            if (j + 1 <= end && nums[j + 1] > nums[j]){
                j++;
            }
            if (nums[j] > nums[k]){
                swap(nums,j, k);
            }else {
                break;
            }
            // 将子节点也进行寻找最大值。
            k = j;
        }
    }


    // 将数组整理成堆。从倒数第二层开始整理。
    private void heapify(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0 ; i--) {
            // 只需要从 i = (len - 1) / 2 位置开始下沉。
            siftDown(nums, i ,len - 1);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
