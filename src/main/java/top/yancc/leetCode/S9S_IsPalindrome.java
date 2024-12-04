package top.yancc.leetCode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 9. ������
 * ����һ������ x ����� x ��һ���������������� true �����򣬷��� false ��
 * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 *
 * ���磬121 �ǻ��ģ��� 123 ���ǡ�
 * ʾ�� 1��
 * ���룺x = 121
 * �����true
 *
 * ʾ�� 2��
 * ���룺x = -121
 * �����false
 * ���ͣ��������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
 *
 * ʾ�� 3��
 * ���룺x = 10
 * �����false
 * ���ͣ����������, Ϊ 01 �����������һ����������
 *
 * ��ʾ��
 * -231 <= x <= 231 - 1
 *
 */
public class S9S_IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return false;
            }
            reversed = reversed * 10 + pop;
        }
        return original == reversed;
    }

    @Test
    public void testIsPalindrome() {
        S9S_IsPalindrome solution = new S9S_IsPalindrome();

        assertTrue(solution.isPalindrome(121));
        assertFalse(solution.isPalindrome(-121));
        assertFalse(solution.isPalindrome(10));
        assertTrue(solution.isPalindrome(0));
        assertTrue(solution.isPalindrome(12321));
    }

}
