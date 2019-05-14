package com.lm.algorithm.primary.array;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-17 17:02
 * @Description:给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return new int[]{};
        int i = digits.length - 1;
        int[] result = digits;
        while (digits[i] == 9 && i != 0) {
            digits[i] = 0;
            i--;
        }
        if (i != 0 || digits[i] != 9) {
            digits[i] += 1;
        } else {
            result = new int[digits.length + 1];
            result[0] = 1;
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(new int[]{4, 3, 2, 1});
        plusOne.plusOne(new int[]{9, 9});
        plusOne.plusOne(new int[]{9, 8});
    }

}
