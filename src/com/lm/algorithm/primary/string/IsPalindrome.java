package com.lm.algorithm.primary.string;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 08:41
 * @Description:给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */

public class IsPalindrome {

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0)
            return true;
        int end = s.length() - 1;
        for (int i = 0, j = end; i < j; i++,j--) {
            while (i < j && !isNumOrChar(s.charAt(i))) {
                i++;
            }
            while (i < j && !isNumOrChar(s.charAt(j))) {
                j--;
            }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }

    private boolean isNumOrChar(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
        return false;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome.isPalindrome("race a car"));
    }

}
