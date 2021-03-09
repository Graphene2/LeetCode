package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/** 后序遍历可以理解为根右左进行后进行反转！
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/10 20:10-20:27
 */
public class lcN叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return ans;
        stack.push(root);

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            ans.addFirst(cur.val);
            for (Node child:cur.children){
                if (child != null){
                    stack.push(child);
                }
            }
        }
        return ans;
    }
}

