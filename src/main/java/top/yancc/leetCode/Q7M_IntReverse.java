package top.yancc.leetCode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 7. ������ת
 * ����һ�� 32 λ���з������� x �����ؽ� x �е����ֲ��ַ�ת��Ľ����
 * �����ת���������� 32 λ���з��������ķ�Χ [?231,  231 ? 1] ���ͷ��� 0��
 * ���軷��������洢 64 λ�������з��Ż��޷��ţ���
 *
 * ʾ�� 1��
 * ���룺x = 123
 * �����321
 *
 * ʾ�� 2��
 * ���룺x = -123
 * �����-321
 *
 * ʾ�� 3��
 * ���룺x = 120
 * �����21
 *
 * ʾ�� 4��
 * ���룺x = 0
 * �����0
 *
 * ��ʾ��
 * -231 <= x <= 231 - 1
 */
public class Q7M_IntReverse {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void testReverse() {
        Q7M_IntReverse solution = new Q7M_IntReverse();

        assertEquals(321, solution.reverse(123));
        assertEquals(-321, solution.reverse(-123));
        assertEquals(21, solution.reverse(120));
        assertEquals(0, solution.reverse(0));
        assertEquals(0, solution.reverse(1534236469)); // This should return 0 due to overflow
    }
}
