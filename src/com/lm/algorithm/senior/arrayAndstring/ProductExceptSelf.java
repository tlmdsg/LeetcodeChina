package com.lm.algorithm.senior.arrayAndstring;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-17 14:59
 * @Description:给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int[] result1 = new int[nums.length];
        int[] result2 = new int[nums.length];
        for (int i = 0; i < result1.length; i++) {
            if (i == 0)
                result1[i] = 1;
            else {
                result1[i] = result1[i - 1] * nums[i - 1];
            }
        }
        for (int i = result2.length - 1; i >= 0; i--) {
            if (i == result2.length - 1)
                result2[i] = 1;
            else {
                result2[i] = result2[i + 1] * nums[i + 1];
            }
        }
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        for (int i = 0; i < result1.length; i++) {
            result1[i] *= result2[i];
        }
        return result1;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
    }

}
