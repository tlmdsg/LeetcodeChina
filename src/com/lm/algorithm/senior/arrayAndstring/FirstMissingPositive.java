package com.lm.algorithm.senior.arrayAndstring;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-18 20:09
 * @Description:第一个缺失的正数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1) && nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 2}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

}
