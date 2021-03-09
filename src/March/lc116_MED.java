package March;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-02
 * Time: 9:24
 */
public class lc116_MED {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            int size = queue.size();
            Node temp = queue.get(0);
            // 将本层连接上next。
            for (int i = 1; i < size; i++) {
                temp.next = queue.get(i);
                temp = queue.get(i);
            }
            // 讲下一层加入到队列中。
            for (int i = 0; i < size; i++) {
                temp = queue.remove();
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
        return root;
    }
    public Node connect2(Node root) {
        if (root == null){
            return root;
        }
        Node pre = root;
        while (pre.left != null){
            Node tmp = pre;
            while (tmp != null){
                // 首先由tmp存在，连接
                tmp.left.next = tmp.right;
                if (tmp.next != null){
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            // 直接寻找下一层！
            pre = pre.left;
        }
        return root;
    }
    // 递归方法！
    public Node connect3(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node root) {
        if (root == null){
            return;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }


}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};