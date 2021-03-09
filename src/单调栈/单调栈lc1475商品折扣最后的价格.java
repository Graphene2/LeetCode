package 单调栈;

import java.util.Stack;

/**lc1475商品折扣最后的价格: 采用单调栈的方式去寻找下一个比当前元素大的元素。
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/20 14:46
 */
public class 单调栈lc1475商品折扣最后的价格 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++){
            // 进栈的实际上是数组的位置坐标。
            while (!stack.isEmpty() &&  prices[stack.peek()] >= prices[i]){
                int index = stack.pop();
                prices[index] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
