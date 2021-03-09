package hot100;

import java.util.ArrayDeque;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-22
 * Time: 9:09
 */
public class lc239滑动窗口最大值 {
    ArrayDeque<Integer> deq = new ArrayDeque<>();
    int[] nums;
    // 这个双端队列构成一个最大堆，也就是降序排列的栈。
    public void clean_deque(int i, int k) {
        if (!deq.isEmpty() && deq.getFirst() <= i - k){
            deq.removeFirst();
        }
        // 该while保证了deque中元素不为空且为降序排列。
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0){
            return new int[0];
        }
        if (k == 1){
            return nums;
        }

        // 初始化双端队列和输入列表
        this.nums = nums;
        int maxIdex = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i,k);
            deq.addLast(i);
            if (nums[i] > nums[maxIdex]) maxIdex = i;
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[maxIdex];
        for (int i = k; i < n; i++) {
            clean_deque(i,k);
            deq.addLast(i);
            res[i - k + 1] = nums[deq.getFirst()];
        }
        return res;
    }



}
