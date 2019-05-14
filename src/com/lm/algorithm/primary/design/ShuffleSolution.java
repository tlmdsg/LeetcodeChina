package com.lm.algorithm.primary.design;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-29 13:26
 * @Description:打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */

public class ShuffleSolution {

    private final int[] source;
    private final Random random = new Random();

    public ShuffleSolution(int[] nums) {
        source = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return Arrays.copyOf(source, source.length);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(source, source.length);
        for (int i = shuffled.length - 1; i > 0; i--) {
            int rand = random.nextInt(i + 1);
            swap(shuffled, i, rand);
        }
        return shuffled;
    }

    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        return;
    }

    public static void main(String[] args) {
        ShuffleSolution shuffleSolution = new ShuffleSolution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(shuffleSolution.shuffle()));
        System.out.println(Arrays.toString(shuffleSolution.shuffle()));
        System.out.println(Arrays.toString(shuffleSolution.reset()));
    }

}
