package com.lm.algorithm.primary.array;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-16 17:01
 * @Description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i, j = 1;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(j);
        return j;
    }

    //交换函数
    private void swap(int[] nums, int x, int y) {
        if (nums == null || nums.length <= x || nums.length <= y)
            return;
        nums[x] = nums[x] ^ nums[y];
        nums[y] = nums[x] ^ nums[y];
        nums[x] = nums[x] ^ nums[y];
        return;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});

    }

}
