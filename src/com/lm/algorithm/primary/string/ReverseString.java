package com.lm.algorithm.primary.string;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019/3/24 19:06
 * @Description:编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */

public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0)
            return;
        int i = 0, j = s.length - 1;
        while (i < j) {
            if (s[i] != s[j])
                swap(s, i, j);
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
        return;
    }

    private void swap(char[] s, int x, int y) {
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
        return;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }

}
