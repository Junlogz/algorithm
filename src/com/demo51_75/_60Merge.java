package com.demo51_75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: JunLog
 * @Description: 区间合并
 * Date: 2022/8/21 10:29
 */
public class _60Merge {

    public class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }

    // Time：O(n*log(n)), Space：O(1)
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        intervals.sort((a, b) -> a.start - b.start);

        for (Interval in : intervals) {
            int n = result.size();
            if (result.isEmpty() || result.get(n - 1).end < in.start) {
                result.add(in);
            } else {
                result.get(n - 1).end = Math.max(result.get(n - 1).end, in.end);
            }
        }
        return result;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval: intervals) {
            int n = merged.size();
            // 如果列表为空,或者当前区间与上一区间不重合,直接添加
            if (merged.size() == 0 || merged.get(n - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 否则的话,我们就可以与上一区间进行合并
                merged.get(n - 1)[1] = Math.max(merged.get(n - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }

}
