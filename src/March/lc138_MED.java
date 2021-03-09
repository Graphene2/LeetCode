package March;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-02
 * Time: 16:32
 */
public class lc138_MED {
    //  使用hash存储原结点和克隆结点的映射关系，通过映射关系处理克隆结点的random指针
    public Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }
        Node node = head;
        Map<Node,Node> map = new HashMap<>();
        while (node != null){
            Node clone = new Node(node.val);
            map.put(node,clone);
            node = node.next;
        }
        node = head;
        while (node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
    // 原地处理，将克隆节点放在原节点后面，在原链表上处理克隆节点的random指针，最后分离两个链表。
    public Node copyRandomList2(Node head) {
        if (head == null){
            return head;
        }
        Node node = head;
        // 将克隆节点复制到
        while (node != null){
            Node clone = new Node(node.val);
            Node temp = node.next;
            node.next = clone;
            node = temp;
        }
        // 处理random节点
        node = head;
        while (node != null){
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        // 进行链表的分离
        node = head;
        Node clonedHead = head.next;
        while (node.next != null){
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return clonedHead;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

