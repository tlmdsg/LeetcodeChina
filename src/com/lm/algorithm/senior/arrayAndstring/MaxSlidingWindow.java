package com.lm.algorithm.senior.arrayAndstring;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-19 21:32
 * @Description:
 */

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> indexs = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = i - k + 1;
            if (i >= k) {
                if (indexs.get(0) < cur)
                    indexs.removeFirst();
            }
            int j = indexs.size() - 1;
            while (!indexs.isEmpty() && nums[i] > nums[indexs.get(j)]) {
                indexs.removeLast();
                j--;
            }
            indexs.add(i);
            if (cur >= 0)
                result[cur] = nums[indexs.get(0)];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

}
