package com.demo1_25;

import java.util.*;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/8/10 9:21
 */
public class _11Permute {

//    public static void main(String[] args) {
//        int[] arr = {0, 1, 2};
//        List<List<Integer>> permute = permute(arr);
//        System.out.println(permute);
//    }
//
//    static void permuteRec(List<Integer> nums, int start, List<List<Integer>> result){
//        if (start == nums.size()){
//            result.add(new ArrayList<>(nums));
//        } else {
//            for (int i = start; i < nums.size(); ++i) {
//                Collections.swap(nums, i , start);
//                permuteRec(nums, start + 1, result);
//                Collections.swap(nums, i , start);
//            }
//        }
//    }
//
//    public static List<List<Integer>> permute(int[] nums) {
//        if (nums == null || nums.length == 0) return new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
//
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        permuteRec(list, 0, result);
//        return result;
//    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("===递归前 ==>" + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("---递归后 -->" + path);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        _11Permute solution = new _11Permute();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }


}
