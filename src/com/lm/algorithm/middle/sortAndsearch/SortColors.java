package com.lm.algorithm.middle.sortAndsearch;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-13 15:26
 * @Description:给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null)
            return;
        int x = 0, y = nums.length - 1;
        for (int i = 0; i <= y && x <= y; ) {
            if (nums[i] == 0) {
                if (i == x){
                    i++;
                    x++;
                }else {
                    swap(nums, i , x++);
                }
            } else if (nums[i] == 2) {
                swap(nums, i, y--);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2, 0, 2, 1, 1, 0});
        sortColors.sortColors(new int[]{2, 0, 1});
    }

}
