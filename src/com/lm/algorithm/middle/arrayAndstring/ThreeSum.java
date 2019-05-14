package com.lm.algorithm.middle.arrayAndstring;

import java.util.*;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-03 13:02
 * @Description:给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        Set<ThreeElement> set = new HashSet<>();
        int limit = nums.length - 3;
        for (int i = 0; i <= limit; i++) {
            int target = 0 - nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int twoSum = nums[j] + nums[k];
                if (twoSum == target) {
                    ThreeElement threeElement = new ThreeElement(nums[i], nums[j], nums[k]);
                    set.add(threeElement);
                    j++;
                    k--;
                } else if (twoSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        for (ThreeElement e : set) {
            result.add(e.toList());
        }
        System.out.println(result);
        return result;
    }

    private static class ThreeElement {
        int i;
        int j;
        int k;

        public ThreeElement(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        public List<Integer> toList() {
            List<Integer> ele = new ArrayList<>();
            ele.add(i);
            ele.add(j);
            ele.add(k);
            return ele;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ThreeElement) {
                ThreeElement oth = (ThreeElement) obj;
                if (i == oth.i && j == oth.j && k == oth.k) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = i;
            hash = hash * 31 + j;
            hash = hash * 31 + k;
            return hash;
        }

        @Override
        public String toString() {
            return "[" +
                    "i=" + i +
                    ", j=" + j +
                    ", k=" + k +
                    ']';
        }
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        threeSum.threeSum(new int[]{-2, 0, 0, 2, 2});
    }

}
