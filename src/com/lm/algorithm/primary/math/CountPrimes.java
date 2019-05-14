package com.lm.algorithm.primary.math;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-30 09:44
 * @Description:统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */

public class CountPrimes {

    //循环判断法，时间复杂度高
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int count = 1;
        for (int i = 3; i < n; i++) {
            int limit = (int) Math.sqrt(i) + 1;
            boolean isPrime = true;
            for (int j = 2; j < limit; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            count = isPrime ? count + 1 : count;
        }
        return count;
    }

    //筛选法
    public int countPrimes2(int n) {
        if (n <= 2)
            return 0;
        int count = 0;
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                count++;
                for (int j = i * 2; j < n; j = j + i) {
                    prime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes2(10));
    }

}
