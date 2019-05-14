package com.lm.algorithm.primary.sortAndsearch;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 19:30
 * @Description:给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int i = m + n - 1, j = m - 1, k = n - 1;
        for (; i >= 0; i--) {
            if (j < 0) {
                nums1[i] = nums2[k];
                k--;
                continue;
            }
            if (k < 0) {
                nums1[i] = nums1[j];
                j--;
                continue;
            }
            if (nums1[j] < nums2[k]) {
                nums1[i] = nums2[k];
                k--;
            } else {
                nums1[i] = nums1[j];
                j--;
            }
        }
        System.out.println(Arrays.toString(nums1));
        return;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[]{1, 3, 4, 0, 0, 0}, 3, new int[]{1, 2, 6}, 3);
    }

}
