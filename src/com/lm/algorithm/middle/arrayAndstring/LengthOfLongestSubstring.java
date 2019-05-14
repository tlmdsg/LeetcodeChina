package com.lm.algorithm.middle.arrayAndstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-07 16:44
 * @Description:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int maxLength = 0, origin = -1;
        for (int i = 0; i < cs.length; i++) {
            if (map.containsKey(cs[i])) {
                int pre = map.get(cs[i]);
                if (pre > origin) {
                    origin = pre;
                }
            }
            map.put(cs[i], i);
            maxLength = (i - origin) >= maxLength ? (i - origin) : maxLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("a"));
    }

}
