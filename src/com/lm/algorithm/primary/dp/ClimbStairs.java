package com.lm.algorithm.primary.dp;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 20:00
 * @Description:
 */

public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 0)
            return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.climbStairs(5);
    }

}
