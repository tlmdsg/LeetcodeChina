package com.lm.algorithm.primary.string;

/**
 * @Auther: 田黎明
 * @Date: 2019/3/24 19:19
 * @Description:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 */

public class Reverse {

    public int reverse(int x) {
        long result = 0, prefix = 1;
        if (x < 0) {
            if (x == Integer.MIN_VALUE)
                return 0;
            prefix = -1;
            x = -x;
        }
        int v = 0;
        while (x != 0) {
            v = x % 10;
            result = result * 10 + v;
            x = x / 10;
        }
        result = result * prefix;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        else
            return (int) result;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse.reverse(Integer.MIN_VALUE));
        System.out.println(reverse.reverse(Integer.MAX_VALUE));
        System.out.println(reverse.reverse(-123));
        System.out.println(new Integer('a'));
        System.out.println('a');
        System.out.println((int)'a');
    }

}
