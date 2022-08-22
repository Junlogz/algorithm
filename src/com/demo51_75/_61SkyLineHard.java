package com.demo51_75;

import java.util.*;

/**
 * @author: JunLog
 * @Description: 218. 天际线问题
 * Date: 2022/8/21 11:55
 */
public class _61SkyLineHard {


    // Time：O(n^2), Space：O(n)
    public List<int[]> skyLineHard(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        height.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int preHeight = 0;
        for (int[] h : height) {
            if (h[1] < 0) pq.add(-h[1]);
            else pq.remove(h[1]);

            if (pq.peek() != preHeight) {
                result.add(new int[]{h[0], pq.peek()});
                preHeight = pq.peek();
            }
        }
        return result;
    }

    public List<List<Integer>> getSkyline(int[][] bs) {
        List<List<Integer>> ans = new ArrayList<>();

        // 预处理所有的点，为了方便排序，对于左端点，令高度为负；对于右端点令高度为正
        List<int[]> ps = new ArrayList<>();
        for (int[] b : bs) {
            int l = b[0], r = b[1], h = b[2];
            ps.add(new int[]{l, -h});
            ps.add(new int[]{r, h});
        }

        ps.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        int prev = 0;
        q.add(prev);

        for (int[] p : ps) {
            int point = p[0], height = p[1];

            if (height < 0) {
                // 如果是左端点 将-h存入
                q.add(-height);
            } else {
                // 右端点的话说明这条边结束了 移除
                q.remove(height);
            }

            // 取出高度
            int cur = q.peek();
            // 如果当前不与前一矩形“上边”延展而来的那些边重合
            if (cur != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(point);
                list.add(cur);
                ans.add(list);
                prev = cur;
            }
        }
        return ans;
    }

}
