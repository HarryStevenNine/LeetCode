package top.yancc.leetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class Q1S_NumberSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    @Test
    public void testTwoSum() {
        Q1S_NumberSum solution = new Q1S_NumberSum();

        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    public void testTwoSumNoSolution() {
        Q1S_NumberSum solution = new Q1S_NumberSum();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            solution.twoSum(new int[]{1, 2, 3}, 7);
        });

        String expectedMessage = "No two sum solution";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
