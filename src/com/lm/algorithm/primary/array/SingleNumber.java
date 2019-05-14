package com.lm.algorithm.primary.array;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-17 16:21
 * @Description:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 */

public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException();
        int result = nums[0];
        for (int i = 1; i < nums.length; i++)
            result ^= nums[i];
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2});
    }

}
