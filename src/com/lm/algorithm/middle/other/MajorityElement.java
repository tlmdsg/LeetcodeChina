package com.lm.algorithm.middle.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-17 12:59
 * @Description:
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        Map<Integer, Integer> map = new HashMap<>();
        int l = nums.length / 2;
        for (int e : nums) {
            int c;
            if (map.containsKey(e))
                c = map.get(e) + 1;
            else
                c = 1;
            if (c > l)
                return e;
            map.put(e, c);
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement.majorityElement(new int[]{}));
        System.out.println(majorityElement.majorityElement(new int[]{3}));
        System.out.println(majorityElement.majorityElement(new int[]{3, 2}));
        System.out.println(majorityElement.majorityElement(new int[]{3, 2, 3}));
    }

}
