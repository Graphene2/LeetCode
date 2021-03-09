package March;

import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-06
 * Time: 9:56
 */
public class lc503_MED {
        /*
        求左边第一个小于它的数：维护一个沿栈顶方向递增的栈，并从头到尾遍历数组
        求左边第一个大于它的数：维护一个沿栈顶方向递减的栈，并从头到尾遍历数组
        求右边第一个小于它的数：维护一个沿栈顶方向递增的栈，并从尾到头遍历数组
        求右边第一个大于它的数：维护一个沿栈顶方向递减的栈，并从尾到头遍历数组
        */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0){
            return nums;
        }
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[len];
        stack.push(nums[len - 1]);
        // 先用递减单调栈形成一个单调栈！
        for (int i = len - 2; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        // 在已有单调栈基础上进行筛选，然后就行操作。
        for (int i = len - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i] = -1;
            }else {
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
    }
    // 官方答案更加简单，栈存储的是位置坐标
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && res[stack.peek()] < nums[i % n]){
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
