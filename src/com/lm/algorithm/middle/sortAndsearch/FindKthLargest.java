package com.lm.algorithm.middle.sortAndsearch;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-14 13:38
 * @Description:在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        initHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, i, 0);
                keepHeap(0, nums, k);
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[0];
    }

    //初始化长度为k的小顶堆
    private void initHeap(int[] nums, int k) {
        int l = (k - 1) / 2;
        for (int i = l; i >= 0; i--) {
            keepHeap(i, nums, k);
        }
    }

    //调整i位置的元素保持长度为k的小顶堆特性
    private void keepHeap(int i, int[] nums, int k) {
        int limit = k - 1;
        int left = i * 2 + 1, min = left;
        int right = left + 1;
        while (i < limit && left <= limit) {
            if (right <= limit && nums[left] >= nums[right]) {
                min = right;
            }
            if (nums[min] < nums[i]) {
                swap(nums, min, i);
                keepHeap(min, nums, k);
            } else {
                return;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

}
