package com.lm.algorithm.middle.arrayAndstring;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-03 19:22
 * @Description:给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;
        int x = matrix.length, y = matrix[0].length;
        int[][] copy = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < x; k++) {
                        copy[k][j] = 1;
                    }
                    for (int k = 0; k < y; k++) {
                        copy[i][k] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = copy[i][j] == 1 ? 0 : matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return;
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes(new int[][]{{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}});
    }

}
