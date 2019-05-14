package com.lm.algorithm.primary.array;

import java.util.HashSet;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-17 16:13
 * @Description:给定一个整数数组，判断是否存在重复元素。 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 */

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int a : nums) {
            if (set.contains(a))
                return true;
            set.add(a);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4}));
    }

}
