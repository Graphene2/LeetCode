package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: zhangcheng
 * Date: 2020-12-14
 * Time: 10:08
 */
public class lc146LRU缓存机制 {
    class LRULinkedNode {
        int key, val;
        LRULinkedNode next, prev;
        public LRULinkedNode() {}
        public LRULinkedNode(int _key, int _value) {
            this.key = _key;
            this.val = _value;
        }
    }
    private Map<Integer, LRULinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LRULinkedNode head, tail;
    public lc146LRU缓存机制(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LRULinkedNode();
        tail = new LRULinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LRULinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;

    }

    public void put(int key, int value) {
        LRULinkedNode node = cache.get(key);
        if (node == null){
            LRULinkedNode newNode = new LRULinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity){
                LRULinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(LRULinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LRULinkedNode removeTail() {
        LRULinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(LRULinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(LRULinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}



