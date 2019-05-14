package com.lm.algorithm.primary.array;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-23 22:41
 * @Description:给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]s
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        if (matrix == null)
            return;
        int n = matrix[0].length - 1;
        int limit = n / 2;
        for (int row = 0; row <= limit; row++)
            for (int col = row; col < n - row; col++) {
                rotate(matrix, row, col);
            }
        System.out.println(Arrays.deepToString(matrix));
        return;
    }

    public void rotate(int[][] matrix, int row, int col) {
        int n = matrix[0].length - 1, tmp = matrix[row][col];
        if (col < row || row > n / 2)
            return;
        matrix[row][col] = matrix[n - col][row];
        matrix[n - col][row] = matrix[n - row][n - col];
        matrix[n - row][n - col] = matrix[col][n - row];
        matrix[col][n - row] = tmp;
    }


    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        });
    }

}
