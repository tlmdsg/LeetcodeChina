package com.lm.algorithm.middle.backtrack;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-13 14:18
 * @Description:给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
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
        } else {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    backtrack(l + 1, nums, list, result);
                }
                if (i == 1) {
                    list.addLast(nums[l]);
                    backtrack(l + 1, nums, list, result);
                    list.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[]{1, 2, 3});
    }

}
