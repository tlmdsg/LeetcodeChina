package com.lm.algorithm.senior.arrayAndstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-19 20:17
 * @Description:最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                if (map.containsKey(nums[i] - 1)) {
                    maxLength = Math.max(maxLength, merge(map, nums[i] - 1, nums[i]));
                }
                if (map.containsKey(nums[i] + 1)) {
                    maxLength = Math.max(maxLength, merge(map, nums[i], nums[i] + 1));
                }
            }
        }
        return maxLength;
    }

    private int merge(Map<Integer, Integer> map, int x, int y) {
        int ll = map.get(x);
        int rl = map.get(y);
        int length = ll + rl;
        int begin = x - ll + 1;
        int end = y + rl - 1;
        map.put(begin, length);
        map.put(end, length);
        return length;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

}
