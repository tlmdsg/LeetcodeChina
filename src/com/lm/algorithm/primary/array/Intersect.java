package com.lm.algorithm.primary.array;

import java.util.*;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-17 16:28
 * @Description:给定两个数组，编写一个函数来计算它们的交集。 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 */

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList();
        for (int e : nums1) {
            if (map.containsKey(e))
                map.put(e, map.get(e) + 1);
            else
                map.put(e, 1);
        }
        for (int e : nums2) {
            if (map.containsKey(e) && map.get(e) > 0) {
                result.add(e);
                map.put(e, map.get(e) - 1);
            }
        }
        return list2Array(result);
    }

    private int[] list2Array(List<Integer> list) {
        int[] result = new int[list.size()];
        int i = 0;
        for (; i < result.length; i++)
            result[i] = list.get(i);
//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        intersect.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }

}
