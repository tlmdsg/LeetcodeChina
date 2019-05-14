package com.lm.algorithm.middle.sortAndsearch;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-14 14:34
 * @Description:峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * 你的解法应该是 O(logN) 时间复杂度的。
 */

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length - 1;
        if (n == 0 || nums[0] > nums[1])
            return 0;
        if (nums[n] > nums[n - 1])
            return n;
        int left = 1, right = n - 1, mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }

    public int findPeakElement1(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length - 1;
        if (n == 0 || nums[0] > nums[1])
            return 0;
        if (nums[n] > nums[n - 1])
            return n;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(new int[]{1, 3, 2, 1}));
    }

}
