package com.lm.algorithm.primary.string;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-28 10:28
 * @Description:报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下： 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */

public class CountAndSay {

    public String countAndSay(int n) {

        String[] ss = new String[n];
        ss[0] = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char c = ss[i - 1].charAt(0);
            int count = 1;
            for (int j = 1; j < ss[i - 1].length(); j++) {
                if (ss[i - 1].charAt(j) == c)
                    count++;
                else {
                    sb.append(count).append(c);
                    c = ss[i - 1].charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(c);
            ss[i] = sb.toString();
        }
        return ss[n - 1];
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
        System.out.println(countAndSay.countAndSay(6));
    }

}
