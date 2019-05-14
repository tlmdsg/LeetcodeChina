package com.lm.algorithm.middle.treeAndgraph;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-13 11:21
 * @Description:给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */

public class NumIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && flag[i][j] == false) {
                    n++;
                    setIslandFlag(i, j, flag, grid);
                }
            }
        }
        return n;
    }

    private void setIslandFlag(int i, int j, boolean[][] flag, char[][] grid) {
        flag[i][j] = true;
        if (i >= 1 && flag[i - 1][j] == false && grid[i - 1][j] == '1')
            setIslandFlag(i - 1, j, flag, grid);
        if (j >= 1 && flag[i][j - 1] == false && grid[i][j - 1] == '1')
            setIslandFlag(i, j - 1, flag, grid);
        if (i + 1 < grid.length && flag[i + 1][j] == false && grid[i + 1][j] == '1')
            setIslandFlag(i + 1, j, flag, grid);
        if (j + 1 < grid[i].length && flag[i][j + 1] == false && grid[i][j + 1] == '1')
            setIslandFlag(i, j + 1, flag, grid);

        return;
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

}
