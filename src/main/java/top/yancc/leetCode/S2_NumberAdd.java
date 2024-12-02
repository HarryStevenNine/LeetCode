package top.yancc.leetCode;

import org.junit.jupiter.api.Test;
import top.yancc.leetCode.beans.ListNode;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 */
public class S2_NumberAdd {

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
        S2_NumberAdd solution = new S2_NumberAdd();

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
