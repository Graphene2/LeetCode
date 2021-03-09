package 数组.time_8_11;

import java.util.Arrays;
import java.util.Stack;

/**
 * leetcode.581：最短无序连续子数组 ： 首先来一个暴力法。
 * * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/10 11:26
 */
class lc581_findUnsortedSubarray {
    public static int findUnsortedSubarray1(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++){
            if (snums[i] != nums[i]){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0 );

    }
    // 采用栈的想法寻找无序部分最大值和最小值。

    public static int findUnsortedSubarray2(int[] nums){
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for (int i = 0;i < nums.length; i++){
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int j = nums.length - 1; j >= 0; j--){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]){
                r = Math.max(r, stack.pop());
            }
            stack.push(j);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,9,2,8,4,5,7,8,9};
        int m = findUnsortedSubarray1(nums);
        System.out.println(m);
        int n = findUnsortedSubarray2(nums);
        System.out.println(n);
    }
}

