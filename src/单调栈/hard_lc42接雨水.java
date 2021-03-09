package 单调栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-27
 * Time: 20:32
 */
public class hard_lc42接雨水 {
    public  int  trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1],height[i]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i + 1],height[i]);
        }
        for (int i = 0; i < size; i++) {
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }

    // 单调递减栈
    public  int  trap2(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (current < height.length){
            while (!stack.isEmpty() && height[current] > height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int distance = current - stack.peek() - 1;
                int boundHeight = Math.min(height[current],height[stack.peek()]) - height[top];
                ans += boundHeight * distance;
            }
            stack.push(current);
            current++;
        }
        return ans;
    }
    // 双指针法：
    public  int  trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] >= leftMax){
                    leftMax = height[left];
                }else {
                    ans += leftMax - height[left];

                }
                left++;
            }else {
                if (height[right] >= rightMax){
                    rightMax = height[right];
                }else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }

}
