package com.lm.algorithm.middle.other;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-17 12:44
 * @Description:不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */

public class GetSum {

    public int getSum(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public int getSum1(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        if (carry != 0) {
            sum = getSum(sum, carry);
        }
        return sum;
    }

    public static void main(String[] args) {
        GetSum getSum = new GetSum();
        System.out.println(getSum.getSum(2, 3));
        System.out.println(getSum.getSum(2, -3));
        System.out.println(getSum.getSum(100, 3));
        System.out.println(getSum.getSum(2, 43));
    }

}
