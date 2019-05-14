package com.lm.algorithm.primary.dp;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-29 10:23
 * @Description:给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = dp[i] > max ? dp[i] : max;
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

}
