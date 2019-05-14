package com.lm.algorithm.primary.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-03 12:27
 * @Description:给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class Generate {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0)
            return new ArrayList<>();
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curRow = new LinkedList<>(), preRow;
        curRow.add(1);
        result.add(curRow);
        for (int i = 1; i < numRows; i++) {
            preRow = result.get(i - 1);
            curRow = new LinkedList<>();
            curRow.add(1);
            for (int j = 1; j < preRow.size(); j++) {
                curRow.add((preRow.get(j - 1) + preRow.get(j)));
            }
            curRow.add(1);
            result.add(curRow);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        generate.generate(5);
    }

}
