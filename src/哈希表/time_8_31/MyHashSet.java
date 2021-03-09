package 哈希表.time_8_31;

import java.io.BufferedReader;
import java.util.LinkedList;

/**
 * @author Cheneyzhang2018@gmail.com
 * @date 2020/8/31 15:58
 */
public class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;

    public MyHashSet(){
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for (int i = 0; i < this.keyRange; i++){
            this.bucketArray[i] = new Bucket();
        }
    }
    // 根据hashcode得到hash值。
    protected int _hash(int key){
        return (key % this.keyRange);
    }
    // add操作：
    public void add(int key){
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }
    // remove操作：
    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }
    // contain
    public boolean contains(int key){
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exits(key);
    }


}

class Bucket{
    private LinkedList<Integer> container;

    public Bucket(){
        container = new LinkedList<>();
    }

    public void insert(Integer key){
        int index = this.container.indexOf(key);
        if (index == -1){
            this.container.addFirst(key);
        }
    }

    public void delete(Integer key){
        this.container.remove(key);
    }

    public boolean exits(Integer key){
        int index = this.container.indexOf(key);
        return (index != -1);
    }

}
