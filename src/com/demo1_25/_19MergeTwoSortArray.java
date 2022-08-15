package com.demo1_25;

/**
 * @author: JunLog
 * @Description: 合并两个有序数组
 * Date: 2022/8/11 11:50
 */
public class _19MergeTwoSortArray {

    //Time:O（m + n） space：O（1）
    public void mergeTwoSortArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i])
                nums1[k--] = nums2[j--];
            else
                nums1[k--] = nums2[i--];
        }
        while (j >= 0) nums1[k--] = nums2[j--];
    }

}
