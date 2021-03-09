package March;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-05
 * Time: 9:28
 */
public class lc232_EAZY {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public lc232_EAZY() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                int temp = inStack.pop();
                outStack.push(temp);
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                int temp = inStack.pop();
                outStack.push(temp);
            }
        }
        return outStack.peek();
    }


    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
