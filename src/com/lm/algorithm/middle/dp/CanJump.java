package com.lm.algorithm.middle.dp;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-16 18:36
 * @Description:
 */

public class CanJump {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return true;
        int reach = nums[0], i = 1, limit = nums.length - 1, cur;
        while (i <= reach && reach < limit) {
            cur = nums[i] + i;
            reach = cur > reach ? cur : reach;
            i++;
        }
        if (reach >= limit)
            return true;
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump.canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
