package com.lm.algorithm.middle.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-13 12:49
 * @Description:给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinations {

    private static final List<Character>[] letters = new List[10];

    static {
        letters[2] = Arrays.asList('a', 'b', 'c');
        letters[3] = Arrays.asList('d', 'e', 'f');
        letters[4] = Arrays.asList('g', 'h', 'i');
        letters[5] = Arrays.asList('j', 'k', 'l');
        letters[6] = Arrays.asList('m', 'n', 'o');
        letters[7] = Arrays.asList('p', 'q', 'r', 's');
        letters[8] = Arrays.asList('t', 'u', 'v');
        letters[9] = Arrays.asList('w', 'x', 'y', 'z');
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        int[] ints = string2IntArray(digits);
        List<String> result = new LinkedList<>();
        backtrack(ints, 0, "", result);
        System.out.println(result);
        return result;
    }

    private void backtrack(int[] ints, int l, String str, List<String> result) {
        if (l == ints.length)
            result.add(str);
        else {
            int key = ints[l];
            for (int i = 0; i < letters[key].size(); i++) {
                backtrack(ints, l + 1, str + letters[key].get(i), result);
            }
        }
    }

    private int[] string2IntArray(String str) {
        int[] ints = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ints[i] = str.charAt(i) - '0';
        }
        return ints;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        letterCombinations.letterCombinations("23");
    }

}
