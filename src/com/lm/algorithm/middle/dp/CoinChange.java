package com.lm.algorithm.middle.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-16 19:45
 * @Description:
 */

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= amount; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; coins[0] * i <= amount; i++) {
            dp[0][coins[0] * i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i])
                    dp[i][j] = dp[i - 1][j];
                else {
                    if (dp[i][j - coins[i]] == Integer.MAX_VALUE)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = (dp[i][j - coins[i]] + 1) < dp[i - 1][j] ? (dp[i][j - coins[i]] + 1) : dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
        System.out.println(coinChange.coinChange(new int[]{2, 5, 10, 1}, 27));
    }

}
