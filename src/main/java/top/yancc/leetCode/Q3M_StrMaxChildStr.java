package top.yancc.leetCode;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc",所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b",所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke",所以其长度为 3。
 *      请注意,你的答案必须是 子串 的长度，“pwke” 是一个子序列，不是子串。
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
