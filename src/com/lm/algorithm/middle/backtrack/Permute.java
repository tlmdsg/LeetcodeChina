package com.lm.algorithm.middle.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-13 13:48
 * @Description:给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new LinkedList<>(), result);
        System.out.println(result);
        return result;
    }

    private void backtrack(int l, int[] nums, LinkedList<Integer> list, List<List<Integer>> result) {
        if (l == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = l; i < nums.length; i++) {
                swap(nums, l, i);
                list.addLast(nums[l]);
                backtrack(l + 1, nums, list, result);
                list.removeLast();
                swap(nums, l, i);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        permute.permute(new int[]{1, 2, 3});
    }

}
