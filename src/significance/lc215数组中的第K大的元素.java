package significance;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-19
 * Time: 17:58-19:50
 */
public class lc215数组中的第K大的元素 {
    private static Random random = new Random(System.currentTimeMillis());
    // 方法二，采用快排序分而治之的方法。
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true){
            int index = partition(nums,left,right);
            if (index == target){
                return nums[index];
            }else if (index < target){
                left = index + 1;
            }else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot){
                j++;
                swap(nums,j,i);
            }
        }
        swap(nums,j,left);
        return j;
    }
    // 重写partition函数，使用双指针两边同时缩减，速度更快，同时pivot随机取！
    private int partition2(int[] nums, int left, int right){
        if (right > left){
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums,left,randomIndex);
        }
        int pivot = nums[left];
        int lt = left + 1, rt = right;
        while (true){
            while (lt <= rt && nums[lt] < pivot){
                lt++;
            }
            while (lt <= rt && nums[rt] > pivot){
                rt--;
            }
            if (lt > rt) {
                break;
            }
            swap(nums,lt,rt);
            lt++;rt--;
        }
        swap(nums,left,rt);
        return rt;
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 方法3优先队列。
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最大堆，lambda 表达式应写成：(a, b) -> b - a
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> b - a);
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    // 或者用优先队列的最小堆。
    public int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最小堆，lambda 表达式应写成：(a, b) -> a - b,或者不写。
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len,(a, b) -> a - b);
        for (int i = 0; i < len; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
    // 使用只有k个长度的优先队列。
    public int findKthLargest4(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆，lambda 表达式应写成：(a, b) -> a - b,或者不写。
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k,(a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++){
            Integer topEle = minHeap.peek();
            if (nums[i] > topEle){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

}
