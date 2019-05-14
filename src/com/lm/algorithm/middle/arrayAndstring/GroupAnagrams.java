package com.lm.algorithm.middle.arrayAndstring;

import java.util.*;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-03 22:05
 * @Description:给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> result = new ArrayList<>(map.values());
        System.out.println(result);
        return result;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        List<List<String>> result = new LinkedList<>();
        boolean[] flag = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!flag[i]) {
                List<String> group = new LinkedList<>();
                group.add(strs[i]);
                flag[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if (!flag[j] && equal(strs[i], strs[j])) {
                        group.add(strs[j]);
                        flag[j] = true;
                    }
                }
                result.add(group);
            }
        }
        System.out.println(result);
        return result;
    }

    private static boolean equal(String s1, String s2) {
        if (s1 == s2)
            return true;
        else if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        return String.valueOf(cs1).equals(String.valueOf(cs2));
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

}
