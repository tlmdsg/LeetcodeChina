package com.lm.algorithm.middle.sortAndsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: 田黎明
 * @Date: 2019-04-15 10:04
 * @Description:给出一个区间的集合，请合并所有重叠的区间。 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Merge {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return new ArrayList<>();
        List<Interval> result = new ArrayList<>(intervals.size());
        Collections.sort(intervals, (x, y) -> x.start - y.start);
        result.add(intervals.get(0));
        Interval cur, curN;
        for (int i = 1, j = 0; i < intervals.size(); i++) {
            cur = intervals.get(i);
            curN = result.get(j);
            if (curN.end >= cur.start) {
                curN.end = cur.end > curN.end ? cur.end : curN.end;
            } else {
                result.add(cur);
                j++;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {

    }

}
