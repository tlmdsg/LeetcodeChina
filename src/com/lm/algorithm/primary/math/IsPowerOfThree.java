package com.lm.algorithm.primary.math;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-30 14:41
 * @Description:给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 * 输入: 27
 * 输出: true
 *
 * 示例 2:
 * 输入: 0
 * 输出: false
 *
 * 示例 3:
 * 输入: 9
 * 输出: true
 *
 * 示例 4:
 * 输入: 45
 * 输出: false
 */

public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        int l = Integer.MAX_VALUE / 3;
        for (int i = 3; i <= n; ) {
            if (i == n)
                return true;
            if (i < l)
                i = i * 3;
            else
                break;
        }
        return false;
    }

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        System.out.println(isPowerOfThree.isPowerOfThree(27));
        System.out.println(isPowerOfThree.isPowerOfThree(0));
        System.out.println(isPowerOfThree.isPowerOfThree(9));
        System.out.println(isPowerOfThree.isPowerOfThree(4));
        System.out.println(isPowerOfThree.isPowerOfThree(2147483647));
    }

}
