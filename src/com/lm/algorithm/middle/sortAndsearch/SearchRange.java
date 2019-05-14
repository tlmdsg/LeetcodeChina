package com.lm.algorithm.middle.sortAndsearch;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-15 09:50
 * @Description:给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while (left < right) {
            if (target == nums[mid]) {
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        if (target != nums[mid]) return new int[]{-1, -1};
        left = mid - 1;
        right = mid + 1;
        while (left >= 0) {
            if (target == nums[left])
                left--;
            else
                break;
        }
        while (right < nums.length) {
            if (target == nums[right])
                right++;
            else
                break;
        }
        return new int[]{left + 1, right - 1};
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

}
