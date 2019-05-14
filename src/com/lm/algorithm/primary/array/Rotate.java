package com.lm.algorithm.primary.array;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-17 15:47
 * @Description:给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */

public class Rotate {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return;
        k = k % nums.length;
        int[] ns = Arrays.copyOf(nums, nums.length);
        int index = ns.length - k, i, j;
        for (i = index, j = 0; i < ns.length; i++, j++)
            nums[j] = ns[i];
        for (i = 0; i < index; i++, j++)
            nums[j] = ns[i];
        System.out.println(Arrays.toString(nums));
    }

    public void new_rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return;
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] a, int begin, int end) {
        if (a == null)
            return;
        int temp;
        while (begin < end) {
            temp = a[begin];
            a[begin++] = a[end];
            a[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        rotate.new_rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 10);
    }

}
