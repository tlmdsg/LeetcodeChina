package com.lm.algorithm.primary.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-03 12:41
 * @Description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */

public class IsValid {

    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '{' || cs[i] == '[' || cs[i] == '(')
                stack.add(cs[i]);
            else if (cs[i] == '}' || cs[i] == ']' || cs[i] == ')') {
                if (stack.empty() || stack.pop() != map.get(cs[i]))
                    return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("([)]"));
        System.out.println(isValid.isValid("()[]"));
        System.out.println(isValid.isValid("{[]}"));
    }

}
