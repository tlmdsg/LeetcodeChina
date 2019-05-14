package com.lm.algorithm.middle.arrayAndstring;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-07 17:05
 * @Description:给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] cs = s.toCharArray();
        int begin = 0, end = 0, length = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 1; ; j++) {
                if ((i - j) < 0 || (i + j) >= cs.length || cs[i - j] != cs[i + j]) {
                    if ((j * 2 - 1) > length) {
                        begin = i - j + 1;
                        end = i + j - 1;
                        length = end - begin + 1;
                    }
                    break;
                }
            }
            if (i > 0 && cs[i - 1] == cs[i]) {
                for (int j = 1; ; j++) {
                    if ((i - j - 1) < 0 || (i + j) >= cs.length || cs[i - j - 1] != cs[i + j]) {
                        if ((j * 2) > length) {
                            begin = i - j;
                            end = i + j - 1;
                            length = end - begin + 1;
                        }
                        break;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome =new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("cbbd"));
        System.out.println(longestPalindrome.longestPalindrome("c"));
    }

}
