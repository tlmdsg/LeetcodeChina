package com.lm.algorithm.primary.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-23 21:39
 * @Description:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0, complement; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        System.out.println(Arrays.toString(result));
        return result[1] != 0 ? result : new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(new int[]{3, 2, 4}, 6);
    }

}
