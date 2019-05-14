package com.lm.algorithm.middle.sortAndsearch;

import java.util.*;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-14 00:31
 * @Description:给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, NFrequence> map = new HashMap<>();
        for (int e : nums) {
            if (map.containsKey(e)) {
                map.get(e).fre++;
            } else {
                map.put(e, new NFrequence(e, 0));
            }
        }
        List<NFrequence> list = new ArrayList<>(map.values());
        List<Integer> result = new ArrayList<>(k);
        Collections.sort(list, (x, y) -> y.fre - x.fre);
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).k);
        }
        System.out.println(result);
        return result;
    }

    static final class NFrequence {
        int k;
        int fre;

        NFrequence(int k, int fre) {
            this.k = k;
            this.fre = fre;
        }
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        topKFrequent.topKFrequent(new int[]{1, 1}, 1);
    }

}
