package com.lm.algorithm.primary.other;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-30 16:08
 * @Description:编写一个函数，输入是一个整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000000000001
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */

public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i) & 0x1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(11));
        System.out.println(hammingWeight.hammingWeight(1));
        System.out.println(hammingWeight.hammingWeight(-3));
    }

}
