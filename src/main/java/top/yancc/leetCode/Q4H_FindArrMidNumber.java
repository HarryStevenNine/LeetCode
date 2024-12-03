package top.yancc.leetCode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 */
public class Q4H_FindArrMidNumber {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m <= n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxOfLeft;
                if (i == 0) { maxOfLeft = nums2[j-1]; }
                else if (j == 0) { maxOfLeft = nums1[i-1]; }
                else { maxOfLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ((m + n) % 2 == 1) { return maxOfLeft; }

                int minOfRight;
                if (i == m) { minOfRight = nums2[j]; }
                else if (j == n) { minOfRight = nums1[i]; }
                else { minOfRight = Math.min(nums1[i], nums2[j]); }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return 0.0;
    }


    @Test
    public void testFindMedianSortedArrays() {
        Q4H_FindArrMidNumber solution = new Q4H_FindArrMidNumber();

        assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.00001);
        assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.00001);
        assertEquals(0.0, solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}), 0.00001);
        assertEquals(1.0, solution.findMedianSortedArrays(new int[]{}, new int[]{1}), 0.00001);
        assertEquals(2.0, solution.findMedianSortedArrays(new int[]{2}, new int[]{}), 0.00001);
    }
}
