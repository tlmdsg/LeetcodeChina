package com.lm.algorithm.middle.design;

import java.util.*;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-17 12:14
 * @Description:设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */

public class RandomizedSet {

    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(size, val);
            map.put(val, size++);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int i = map.get(val);
            list.set(i, list.get(size-1));
            map.put(list.get(size-1),i);
            map.remove(val);
            size--;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(size));
    }

    public static void main(String[] args) {

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
