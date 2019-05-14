package com.lm.algorithm.senior.arrayAndstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-17 19:01
 * @Description:给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();
        int x = matrix.length - 1, y = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>(x * y);
        int x1 = 0, y1 = 0, x2 = x, y2 = y;
        while (x1 <= x2 && y1 <= y2) {
            if (x1 == x2) {
                for (int i = y1; i <= y2; i++) {
                    list.add(matrix[x1][i]);
                }
            } else if (y1 == y2) {
                for (int i = x1; i <= x2; i++) {
                    list.add(matrix[i][y1]);
                }
            } else {
                for (int i = y1; i < y2; i++) {
                    list.add(matrix[x1][i]);
                }
                for (int i = x1; i < x2; i++) {
                    list.add(matrix[i][y2]);
                }
                for (int i = y2; i > y1; i--) {
                    list.add(matrix[x2][i]);
                }
                for (int i = x2; i > x1; i--) {
                    list.add(matrix[i][y1]);
                }
            }
            x1++;
            y1++;
            x2--;
            y2--;
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {

    }

}
