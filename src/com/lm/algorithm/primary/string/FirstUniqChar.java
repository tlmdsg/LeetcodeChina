package com.lm.algorithm.primary.string;

import java.util.*;

/**
 * @Auther: 田黎明
 * @Date: 2019/3/24 19:43
 * @Description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 */

public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if (s == null)
            return -1;
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        for (int i = 0; i < cs.length; i++) {
            if (map.get(cs[i]) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("leetcode"));
        System.out.println(firstUniqChar.firstUniqChar("loveleetcode"));
    }

}
