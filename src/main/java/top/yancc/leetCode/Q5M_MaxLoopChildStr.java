package top.yancc.leetCode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
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
