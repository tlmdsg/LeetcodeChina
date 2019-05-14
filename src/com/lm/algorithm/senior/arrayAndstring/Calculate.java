package com.lm.algorithm.senior.arrayAndstring;

import java.util.LinkedList;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-19 20:53
 * @Description:基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */

public class Calculate {

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] cs = s.toCharArray();
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb;
        for (int i = 0; i < cs.length; ) {
            if (cs[i] == ' ')
                i++;
            else if (isOpe(cs[i])) {
                list.add(String.valueOf(cs[i++]));
            } else {
                sb = new StringBuilder();
                while (i < cs.length && cs[i] != ' ' && !isOpe(cs[i])) {
                    sb.append(cs[i]);
                    i++;
                }
                list.add(sb.toString());
            }
        }
        LinkedList<String> nlist = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.equals("*") || str.equals("/")) {
                String x = nlist.removeLast();
                String y = list.get(++i);
                if (str.equals("*"))
                    nlist.add(String.valueOf(Integer.valueOf(x) * Integer.valueOf(y)));
                else
                    nlist.add(String.valueOf(Integer.valueOf(x) / Integer.valueOf(y)));
            } else {
                nlist.add(str);
            }
        }
        int result = Integer.valueOf(nlist.get(0));
        for (int i = 1; i < nlist.size(); i++) {
            String str = nlist.get(i);
            if (str.equals("+")) {
                result += Integer.valueOf(nlist.get(++i));
            } else {
                result -= Integer.valueOf(nlist.get(++i));
            }
        }
        return result;
    }

    private boolean isOpe(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate(" 3+5 / 2 "));
    }

}
