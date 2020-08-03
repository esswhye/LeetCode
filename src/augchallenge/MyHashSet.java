package augchallenge;

import java.util.LinkedList;
import java.util.List;

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet.
 * If the value does not exist in the HashSet, do nothing.
 */
public class MyHashSet {

    //Load factor LF = No of entries occupied/total buckets
    // In java if load factor > 0.75 Load factor is by default 0.75 of the initial capacity (16)
    // therefore 25% of the buckets will be free before there is an increase in the capacity
    // & this makes many new buckets with new hashcodes pointing to
    // them to exist just after the increase in the number of buckets.
    private int numBuckets = 10000;

    //An Array of linked list | int[] ==  Array of int
    private List<Integer>[] buckets;
//    int[] hello2 = new int[10];
//    private List<Integer> hello;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        buckets = new LinkedList[numBuckets];
//        hello = new LinkedList<>();
//        System.out.println(buckets.getClass());
//        System.out.println(hello.getClass());
//        System.out.println(hello2);
    }

    public void add(int key) {
        int i = hashFunction(key);
        if (buckets[i] == null)
            //if bucket[hashedI] is empty we will first instantiate a linkedlist
            buckets[i] = new LinkedList<>();
        if (buckets[i].indexOf(key) == -1) {
            //add the element into the bucket[hashedI]
            buckets[i].add(key);
        }

    }

    public void remove(int key) {
        int i = hashFunction(key);
        if (buckets[i] == null) return;
        if (buckets[i].indexOf(key) != -1) {
            buckets[i].remove(buckets[i].indexOf(key));
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int i = hashFunction(key);
        if (buckets[i] == null || buckets[i].indexOf(key) == -1) return false;
        return true;
    }

    private int hashFunction(int key) {
        //to store it on a bucket
        return key % numBuckets;
    }

    public static void main(String[] args) {

        MyHashSet hashSet = new MyHashSet();
        hashSet.add(5);
        hashSet.add(4);
        hashSet.remove(3);
        hashSet.remove(5);

        System.out.println(hashSet.contains(5));
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */