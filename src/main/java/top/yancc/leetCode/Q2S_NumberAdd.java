package top.yancc.leetCode;

import org.junit.jupiter.api.Test;
import top.yancc.leetCode.beans.ListNode;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 2. �������
 * �������� �ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ��� ���� �ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
 * ���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 * ����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
 *
 * ʾ�� 1��
 * ���룺l1 = [2,4,3], l2 = [5,6,4]
 * �����[7,0,8]
 * ���ͣ�342 + 465 = 807.
 *
 * ʾ�� 2��
 * ���룺l1 = [0], l2 = [0]
 * �����[0]
 *
 * ʾ�� 3��
 * ���룺l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * �����[8,9,9,9,0,0,0,1]
 *
 * ��ʾ��
 * ÿ�������еĽڵ����ڷ�Χ [1, 100] ��
 * 0 <= Node.val <= 9
 * ��Ŀ���ݱ�֤�б��ʾ�����ֲ���ǰ����
 *
 */
public class Q2S_NumberAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    private ListNode createList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummyHead.next;
    }

    private int[] listToArray(ListNode node) {
        int[] result = new int[100];
        int i = 0;
        while (node != null) {
            result[i++] = node.val;
            node = node.next;
        }
        return java.util.Arrays.copyOf(result, i);
    }

    @Test
    public void testAddTwoNumbers() {
        Q2S_NumberAdd solution = new Q2S_NumberAdd();

        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{7, 0, 8}, listToArray(result));

        l1 = createList(new int[]{0});
        l2 = createList(new int[]{0});
        result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{0}, listToArray(result));

        l1 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = createList(new int[]{9, 9, 9, 9});
        result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, listToArray(result));
    }
}
