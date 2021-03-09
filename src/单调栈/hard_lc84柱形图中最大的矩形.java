package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-10-29
 * Time: 14:47-16:41
 */
public class hard_lc84柱形图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]){
                int curHeight = heights[stack.pollLast()];
                // 相等略过是因为当前i本身会计算，所以与当前相等的东西直接去除。
                while (!stack.isEmpty() && curHeight == heights[stack.peekLast()]){
                    stack.pollLast();
                }
                int curWidth;
                if (stack.isEmpty()){
                    curWidth = i;
                }else {
                    curWidth = i - stack.peekLast() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            stack.offerLast(i);
        }
        // 最后全剩单调栈，一个一个进行处理。
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }
}
