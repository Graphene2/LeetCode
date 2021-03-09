package 单调栈;

import java.util.Stack;

/**lc739每日温度
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 15:05
 */
public class 单调栈lc739每日温度_中等 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);

        }
        return ans;
    }
}
