package top.yancc.leetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. ����֮��
 * ����һ���������� nums ��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ target  ���� ���� ���������������ǵ������±ꡣ
 * ����Լ���ÿ������ֻ���Ӧһ���𰸣������㲻��ʹ��������ͬ��Ԫ�ء�
 * ����԰�����˳�򷵻ش𰸡�
 *
 * ʾ�� 1��
 * ���룺nums = [2,7,11,15], target = 9
 * �����[0,1]
 * ���ͣ���Ϊ nums[0] + nums[1] == 9 ������ [0, 1] ��
 *
 * ʾ�� 2��
 * ���룺nums = [3,2,4], target = 6
 * �����[1,2]
 *
 * ʾ�� 3��
 * ���룺nums = [3,3], target = 6
 * �����[0,1]
 *
 * ��ʾ��
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * ֻ�����һ����Ч��
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
