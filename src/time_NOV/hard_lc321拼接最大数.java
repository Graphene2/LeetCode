package time_NOV;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:1. 方法为单调栈,这里采用数组进行模仿单调栈。
 * User: zhangcheng
 * Date: 2020-12-02
 * Time: 9:23-10:55
 */
public class hard_lc321拼接最大数 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubseque = new int[k];
        int start = Math.max(0, k - n), end = Math.min(m, k);
        for (int i = start; i <= end; i++) {
            int[] subSeque1 = maxSub(nums1,i);
            int[] subSeque2 = maxSub(nums2,k - i);
            int[] curMaxSubseque = merge(subSeque1,subSeque2);
            if (compare(curMaxSubseque,0,maxSubseque,0) ){
                System.arraycopy(curMaxSubseque,0,maxSubseque,0,k);
            }
        }
        return maxSubseque;
    }

    private boolean compare(int[] num1,int p1 ,int[] num2,int p2) {
        if (p2 >= num2.length) return true;
        if (p1 >= num1.length) return false;
        if (num1[p1] > num2[p2]) return true;
        if (num1[p1] < num2[p2]) return false;
        return compare(num1,p1 + 1,num2,p2 + 1);
    }


    private int[] merge(int[] subSeque1, int[] subSeque2) {
        int m = subSeque1.length, n = subSeque2.length;
        int[] maxMerge = new int[m + n];
        int ptr1 = 0, ptr2 = 0;
        int i = 0;
        while (ptr1 < m && ptr2 < n){
            if (compare(subSeque1,ptr1,subSeque2,ptr2)){
                maxMerge[i] = subSeque1[ptr1];
                ptr1++;
                i++;
            }else {
                maxMerge[i] = subSeque2[ptr2];
                ptr2++;
                i++;
            }
        }
        if (ptr1 == m){
            while (i < m + n){
                maxMerge[i] = subSeque2[ptr2];
                ptr2++;
                i++;
            }
        }else if (ptr2 == n){
            while (i < m + n){
                maxMerge[i] = subSeque1[ptr1];
                ptr1++;
                i++;
            }
        }
        return maxMerge;
    }


    /**
     * 采用数组模拟单调栈。直接返回数组，而且空间占用稍微小一点
     * @param nums 对象数组
     * @param k 选取的k个数字使结果数组的数字最大
     * @return
     */
    private int[] maxSub(int[] nums, int k) {
        int len = nums.length;
        // remain 表示可以剩余还可丢弃的数字个数。
        int remain = len - k;
        int[] stack = new int[k];
        int top = -1;
        for (int i = 0; i < len; i++) {
            // stack.peek 与 当前比较，如果当前数字更大那么就删除栈尾。
            while (top >= 0 && stack[top] < nums[i] && remain > 0){
                top--;
                remain --;
            }
            if (top < k - 1){
                stack[++top] = nums[i];
            }else {
                remain--;
            }
        }
        return stack;
    }


    public static void main(String[] args) {
        hard_lc321拼接最大数 aa = new hard_lc321拼接最大数();
        int[] num1 = new int[]{6,7};
        int[] num2 = new int[]{6,0,4};
        aa.maxNumber(num1,num2,5);
    }
}
