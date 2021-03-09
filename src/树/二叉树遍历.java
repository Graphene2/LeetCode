package 树;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/9/2 10:50-16:55
 */
class TreePrint {
    // 先序遍历：根左右
    public void preOrderRe(TreeNode biTree){
        // 采用递归实现先序遍历
        System.out.println(biTree.val);
        TreeNode leftTree = biTree.left;
        if (leftTree != null){
            preOrderRe(leftTree);
        }
        TreeNode rightTree = biTree.right;
        if (rightTree != null){
            preOrderRe(rightTree);
        }
    }
    public void preOrder(TreeNode biTree){
        // 采用栈实现先序遍历
        Stack<TreeNode> stack = new Stack<>();
        while (biTree != null || !stack.isEmpty()){
            while (biTree != null){
                System.out.println(biTree.val);
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()){
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }


    // 中序遍历：左根右
    public void midOrderRe(TreeNode biTree){
        // 递归方式实现中序遍历
        if (biTree == null){
            return;
        }else {
            midOrderRe(biTree.left);
            System.out.println(biTree.val);
            midOrderRe(biTree.right);
        }
    }
    public void midOrder(TreeNode biTree){
        // 栈方式实现中序遍历
        Stack<TreeNode> stack = new Stack<>();
        while (biTree != null || !stack.isEmpty()){
            while (biTree != null){
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()){
                biTree = stack.pop();
                System.out.println(biTree.val);
                biTree = biTree.right;
            }
        }
    }
    // 后序遍历：左右根 重点！
    public void postOrderRe(TreeNode biTree){
        // 递归实现后序遍历
        if (biTree == null){
            return;
        }else {
            postOrderRe(biTree.left);
            postOrderRe(biTree.right);
            System.out.println(biTree.val);
        }
    }

    public void postOrder(TreeNode biTree){
        // 栈实现后序遍历
        Stack<TreeNode> stack = new Stack<>();
        int left = 1;
        int right = 2;
        Stack<Integer> stack2 = new Stack<>(); // 辅助栈，用来判断子节点返回父节点时返回的是左节点还是右节点。
        while (biTree != null || !stack.isEmpty()) {
            while (biTree != null){
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.left;
            }
            while (!stack.empty() && stack2.peek() == right){
                // 如果是从右子节点返回父节点，则任务完成，将两个栈弹出
                stack2.pop();
                System.out.println(stack.pop().val);
            }
            if (!stack.empty() && stack2.peek() == left){
                // 如果是从左子节点返回父节点，则将标记改为右子节点。
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().right;
            }
        }
    }

    // 层次遍历:一般用BFS思想去实现。 而前、中、后序是由DFS去实现的。
    // BFS一般是由队列来实现的！
    public void levelOrder(TreeNode bitree){
        // 层次遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(bitree);
        TreeNode currNode;
        while (!queue.isEmpty()){
            currNode = queue.poll();
            System.out.println(currNode.val);
            if (currNode.left != null){
                queue.add(currNode.left);
            }
            if (currNode.right != null){
                queue.add(currNode.right);
            }
        }
    }
    // 重写前序遍历的迭代实现
    public void preOrder2(TreeNode biTree){
        Stack<TreeNode> stack = new Stack<>();
        while (biTree != null || !stack.isEmpty()){
            while (biTree != null){
                System.out.println(biTree.val);
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()){
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }
    // 重写中序遍历的迭代实现
    public void midOrder2(TreeNode biTree){
        Stack<TreeNode> stack = new Stack<>();
        while (biTree != null || !stack.isEmpty()){
            while (biTree != null){
                stack.push(biTree);
                biTree = biTree.left;
            }
            if (!stack.isEmpty()){
                biTree = stack.pop();
                System.out.println(biTree.val);
                biTree = biTree.right;
            }
        }
    }
    // 重写后序遍历的迭代实现
    public void postOrder2(TreeNode biTree){
        Stack<TreeNode> s1 = new Stack<>();
        int left = 1,right = 2;
        Stack<Integer> s2 = new Stack<>();
        while (biTree != null || !s1.isEmpty()){
            while (biTree != null){
                s1.push(biTree);
                s2.push(left);
                biTree = biTree.left;
            }
            // 如果栈顶元素为right，那么移除栈顶元素并打印
            while (!s1.isEmpty() && s2.peek() == right){
                s2.pop();
                System.out.println(s1.pop());
            }
            if (!s1.isEmpty() && s2.peek() == left){
                s2.pop();
                s2.push(right);
                biTree = s1.peek().right;
            }
        }
    }





}


//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
