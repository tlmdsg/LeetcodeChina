package com.lm.algorithm.primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-23 22:02
 * @Description:判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 */

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board == null)
            return false;
        for (int i = 0; i < 9; i++) {
            if (!isValidSudokuOnRow(board[i]))
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (!isValidSudokuOnColumn(board, i))
                return false;
        }
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!isValidSudokuOn33(board, i, j))
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudokuOnRow(char[] row) {
        Set<Character> set = new HashSet<>();
        for (char c : row) {
            if (c == '.')
                continue;
            if (set.contains(c))
                return false;
            else
                set.add(c);
        }
        return true;
    }

    public boolean isValidSudokuOnColumn(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') {
                continue;
            }
            if (set.contains(board[i][col])) {
                return false;
            } else {
                set.add(board[i][col]);
            }
        }
        return true;
    }

    public boolean isValidSudokuOn33(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row + i][col + j] == '.')
                    continue;
                if (set.contains(board[row + i][col + j]))
                    return false;
                else
                    set.add(board[row + i][col + j]);

            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }

}
