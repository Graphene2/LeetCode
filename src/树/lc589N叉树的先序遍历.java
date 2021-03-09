package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/9/2,20:35
 * @version: 1.0
 */
public class lc589N叉树的先序遍历 {
    // 采用递归方法实现先序遍历！
    List<Integer> res ;
    public List<Integer> preorder(Node root) {
        res = new LinkedList<>();
        dfs(root);
        return res;
    }
    public void dfs(Node root){
        if (root == null) return;
        res.add(root.val);
        for (Node child:root.children){
            dfs(child);
        }
    }
    // 采用迭代方法进行先序遍历，可以用栈来实现
    public List<Integer> preorder2(Node root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node currNode = stack.pop();
            //头结点加入结果集
            ans.add(currNode.val);
            List<Node> nodeList = currNode.children;
            //将该节点的子节点从右往左压入栈
            for (int i = nodeList.size() - 1; i >= 0; i--){
                stack.push(nodeList.get(i));
            }
        }
        return ans;
    }

    // 采用迭代方法进行先序遍历，可以用栈来实现
    public List<Integer> preorder3(Node root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node currNode = stack.pollLast();
            //头结点加入结果集
            ans.add(currNode.val);
            List<Node> nodeList = currNode.children;
            //将该节点的子节点从右往左压入栈
            for (int i = nodeList.size() - 1; i >= 0; i--){
                stack.push(nodeList.get(i));
            }
        }
        return ans;
    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};