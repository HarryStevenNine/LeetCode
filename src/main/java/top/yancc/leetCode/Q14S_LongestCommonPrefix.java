package top.yancc.leetCode;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Q14S_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 以第一个字符串为基准
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            // 当前字符串与prefix不断比较，直到找到公共前缀
            while (strs[i].indexOf(prefix) != 0) {
                // 每次去掉最后一个字符，直到找到匹配的前缀
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

   @Test
    public void testLongestCommonPrefix() {
        Q14S_LongestCommonPrefix solution = new Q14S_LongestCommonPrefix();
        
        // 测试用例1：有公共前缀
        String[] strs1 = {"flower", "flow", "flight"};
        assertEquals("fl", solution.longestCommonPrefix(strs1));
        
        // 测试用例2：无公共前缀
        String[] strs2 = {"dog", "racecar", "car"};
        assertEquals("", solution.longestCommonPrefix(strs2));
        
        // 测试用例3：空数组
        String[] strs3 = {};
        assertEquals("", solution.longestCommonPrefix(strs3));
        
        // 测试用例4：单个字符串
        String[] strs4 = {"hello"};
        assertEquals("hello", solution.longestCommonPrefix(strs4));
        
        // 测试用例5：所有字符串相同
        String[] strs5 = {"test", "test", "test"};
        assertEquals("test", solution.longestCommonPrefix(strs5));
    }
}

