package com.lm.algorithm.primary.array;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-17 17:15
 * @Description:给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++)
            nums[j] = 0;
        System.out.println(Arrays.toString(nums));
        return;
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes.moveZeroes(new int[]{1, 0});
    }

}
