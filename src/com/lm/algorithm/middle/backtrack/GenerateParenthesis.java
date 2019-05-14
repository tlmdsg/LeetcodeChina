package com.lm.algorithm.middle.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-13 13:26
 * @Description:给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        backtrack(n, "", 0, result);
        System.out.println(result);
        return result;
    }

    private void backtrack(int n, String str, int m, List<String> result) {
        if (n == 0 && m == 0) {
            result.add(str);
            return;
        } else {
            if (n > 0) {
                backtrack(n - 1, str + '(', m + 1, result);
            }
            if (m > 0) {
                backtrack(n, str + ')', m - 1, result);
            }
        }
    }

    private void backtrack1(int n, String str, Stack<Character> stack, List<String> result) {
        if (n == 0 && stack.isEmpty()) {
            result.add(str);
            return;
        } else {
            if (n > 0) {
                stack.push(')');
                backtrack1(n - 1, str + '(', stack, result);
                stack.pop();
            }
            if (!stack.isEmpty()) {
                backtrack1(n, str + stack.pop(), stack, result);
                stack.push(')');
            }
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }

}
