package com.lm.algorithm.primary.other;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-03 12:52
 * @Description:给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */

public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int result = n;
        for (int i = 0; i < n; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}
