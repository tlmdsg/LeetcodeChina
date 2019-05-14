package com.lm.algorithm.middle.arrayAndstring;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-07 18:54
 * @Description:给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: true
 *
 * 示例 2:
 * 输入: [5,4,3,2,1]
 * 输出: false
 */

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int e : nums) {
            if (e <= min) {
                min = e;
            } else if (e <= mid) {
                mid = e;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

}
