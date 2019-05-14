package com.lm.algorithm.primary.string;

import java.util.Arrays;

/**
 * @Auther: 田黎明
 * @Date: 2019/3/24 20:03
 * @Description:给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 */

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null)
            if (t == null)
                return true;
            else
                return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        if (c1.length != c2.length)
            return false;
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram.isAnagram("rat", "car"));
    }

}
