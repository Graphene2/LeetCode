package hot100;

import java.util.Stack;

/**
 * Description:以空间换时间，辅助栈的常见做法！
 * User: zhangcheng
 * Date: 2020-12-07
 * Time: 9:10
 */
public class lc155MinStack {
    private Stack<Integer> data;
    private Stack<Integer> helper;
    /** initialize your data structure here. */
    public lc155MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x){
            helper.add(x);
        }else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()){
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
