package top.yancc.leetCode;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 3. ���ظ��ַ�����Ӵ�
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 *
 * ʾ�� 1:
 * ����: "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc",�����䳤��Ϊ 3��
 *
 * ʾ�� 2:
 * ����: "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b",�����䳤��Ϊ 1��
 *
 * ʾ�� 3:
 * ����: "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke",�����䳤��Ϊ 3��
 *      ��ע��,��Ĵ𰸱����� �Ӵ� �ĳ��ȣ���pwke�� ��һ�������У������Ӵ���
 */
public class Q3M_StrMaxChildStr {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    @Test
    public void testLengthOfLongestSubstring() {
        Q3M_StrMaxChildStr solution = new Q3M_StrMaxChildStr();

        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, solution.lengthOfLongestSubstring(""));
        assertEquals(2, solution.lengthOfLongestSubstring("aab"));
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
    }
}
