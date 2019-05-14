package com.lm.algorithm.middle.dp;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-16 19:33
 * @Description:
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(3, 2);
        uniquePaths.uniquePaths(7, 3);
    }

}
