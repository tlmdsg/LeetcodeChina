package com.lm.algorithm.primary.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 田黎明
 * @Date: 2019-03-30 09:14
 * @Description:写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 * n = 15,
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        if (n < 1)
            return new ArrayList<>();
        List<String> result = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            boolean mod3 = i % 3 == 0, mod5 = i % 5 == 0;
            if (mod3 && mod5) {
                result.add("FizzBuzz");
                continue;
            }
            if (mod3) {
                result.add("Fizz");
                continue;
            }
            if (mod5) {
                result.add("Buzz");
                continue;
            }
            result.add(String.valueOf(i));
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzBuzz(15);
    }

}
