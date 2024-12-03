package top.yancc.leetCode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 5. ������Ӵ�
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ���
 * ʾ�� 1��
 * ���룺s = "babad"
 * �����"bab"
 * ���ͣ�"aba" ͬ���Ƿ�������Ĵ𰸡�
 *
 * ʾ�� 2��
 * ���룺s = "cbbd"
 * �����"bb"
 *
 * ��ʾ��
 * 1 <= s.length <= 1000
 * s �������ֺ�Ӣ����ĸ���
 */
public class Q5M_MaxLoopChildStr {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    @Test
    public void testLongestPalindrome() {
        Q5M_MaxLoopChildStr solution = new Q5M_MaxLoopChildStr();

        assertEquals("aba", solution.longestPalindrome("babad"));
        assertEquals("bb", solution.longestPalindrome("cbbd"));
        assertEquals("a", solution.longestPalindrome("a"));
        assertEquals("c", solution.longestPalindrome("ac"));
        assertEquals("racecar", solution.longestPalindrome("racecar"));
    }
}
