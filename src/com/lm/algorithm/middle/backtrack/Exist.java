package com.lm.algorithm.middle.backtrack;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-13 15:04
 * @Description:给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */

public class Exist {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null)
            return false;
        char[] cs = word.toCharArray();
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == cs[0] && isWord(i, j, board, flag, 0, cs))
                    return true;
            }
        }
        return false;
    }

    private boolean isWord(int i, int j, char[][] board, boolean[][] flag, int k, char[] cs) {
        if (k == cs.length)
            return true;
        else {
            if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && board[i][j] == cs[k] && flag[i][j] == false) {
                flag[i][j] = true;
                if (isWord(i - 1, j, board, flag, k + 1, cs) || isWord(i, j - 1, board, flag, k + 1, cs) ||
                        isWord(i + 1, j, board, flag, k + 1, cs) || isWord(i, j + 1, board, flag, k + 1, cs)) {
                    return true;
                } else {
                    flag[i][j] = false;
                    return false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Exist exist = new Exist();
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

}
