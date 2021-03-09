package 哈希表.time_8_28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: cheneyzhang2018@gmail.com
 * @date: 2020/8/28,14:16
 * @version: 1.0
 */
public class MyHashMap {
    class Node{
        int key, value;
        Node prev, next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int length = 100;
    private Node[] data = new Node[length];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    public void put(int key, int value) {
        int index = key % length;
        Node curr = data[index];
        // 如果链表为空，创建链表
        if (curr == null) {
            Node node = new Node(key, value);
            data[index] = node;
            return;
        }
        // 如果链表不为空，开始寻找链表的位置。
        while(true) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            if(curr.next == null) {
                Node node = new Node(key, value);
                node.prev = curr;
                curr.next = node;
                return;
            } else {
                curr = curr.next;
            }
        }
    }

    public int get(int key) {
        int index = key % length;
        Node curr = data[index];
        while(curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % length;
        Node curr = data[index];
        // 链表第一个即为该元素对
        if (curr != null && curr.key == key) {
            Node next = curr.next;
            if (next != null) {
                next.prev = null;
            }
            data[index] = next;
            return;
        }
        while(curr != null) {
            if (curr.key == key) {
                Node next = curr.next;
                Node prev = curr.prev;
                if (next != null) {
                    next.prev = prev;
                }
                if (prev != null) {
                    prev.next = next;
                }
                curr = null;
                return;
            }
            curr = curr.next;
        }
    }

}


