package com.lm.algorithm.senior.arrayAndstring;

import sun.jvm.hotspot.tools.SysPropsDumper;

import java.util.Stack;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-17 19:34
 * @Description:给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */

public class MaxArea {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int i = 0, j = height.length - 1;
        int maxArea = 0, min;
        while (i < j) {
            if (height[i] < height[j]) {
                min = height[i];
                maxArea = Math.max(maxArea, (j - i) * min);
                while (i < j && height[i] <= min)
                    i++;
            } else if (height[i] > height[j]) {
                min = height[j];
                maxArea = Math.max(maxArea, (j - i) * min);
                while (i < j && height[j] <= min)
                    j--;
            } else {
                min = height[i];
                maxArea = Math.max(maxArea, (j - i) * min);
                while (i < j && height[i] <= min)
                    i++;
                while (i < j && height[j] <= min)
                    j--;
            }
        }
        return maxArea;
    }

    public int maxArea1(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[max]) {
                max = i;
            }
        }
        Stack<Integer> left = new Stack<>(), right = new Stack<>();
        int maxArea = 0;
        left.add(max);
        right.add(max);
        for (int i = max - 1; i >= 0; i--) {
            while (!left.isEmpty() && height[i] >= height[left.peek()]) {
                left.pop();
            }
            left.add(i);
        }
        for (int i = max + 1; i < height.length; i++) {
            while (!right.isEmpty() && height[i] >= height[right.peek()]) {
                right.pop();
            }
            right.add(i);
        }
        int curLeft = left.pop(), curRight = right.pop();
        while (curLeft != -1 && curRight != -1) {
            int min;
            if (height[curLeft] < height[curRight]) {
                min = height[curLeft];
                maxArea = Math.max(maxArea, (curRight - curLeft) * min);
                if (!left.isEmpty())
                    curLeft = left.pop();
                else
                    curLeft = -1;
            } else if (height[curLeft] > height[curRight]) {
                min = height[curRight];
                maxArea = Math.max(maxArea, (curRight - curLeft) * min);
                if (!right.isEmpty())
                    curRight = right.pop();
                else
                    curRight = -1;
            } else {
                min = height[curRight];
                maxArea = Math.max(maxArea, (curRight - curLeft) * min);
                if (!left.isEmpty())
                    curLeft = left.pop();
                else
                    curLeft = -1;
                if (!right.isEmpty())
                    curRight = right.pop();
                else
                    curRight = -1;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int max = 0;
        for (int h : height) {
            if (h > max) {
                max = h;
            }
        }
        int left, right, maxArea = 0;
        while (max > 0) {
            left = Integer.MIN_VALUE;
            right = Integer.MAX_VALUE;
            for (int i = 0; i < height.length; i++) {
                if (height[i] >= max) {
                    left = i;
                    break;
                }
            }
            for (int i = height.length - 1; i >= left; i--) {
                if (height[i] >= max) {
                    right = i;
                    break;
                }
            }
            if (left >= 0)
                maxArea = Math.max(maxArea, (right - left) * max);
            max--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

}
