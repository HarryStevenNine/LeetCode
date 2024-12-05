package top.yancc.leetCode;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 14. �����ǰ׺
 * ��дһ�������������ַ��������е������ǰ׺��
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * 
 * ʾ�� 1��
 * ���룺strs = ["flower","flow","flight"]
 * �����"fl"
 * 
 * ʾ�� 2��
 * ���룺strs = ["dog","racecar","car"]
 * �����""
 * ���ͣ����벻���ڹ���ǰ׺��
 *
 * ��ʾ��
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] ����СдӢ����ĸ���
 */
public class Q14S_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // �Ե�һ���ַ���Ϊ��׼
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            // ��ǰ�ַ�����prefix���ϱȽϣ�ֱ���ҵ�����ǰ׺
            while (strs[i].indexOf(prefix) != 0) {
                // ÿ��ȥ�����һ���ַ���ֱ���ҵ�ƥ���ǰ׺
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
        
        // ��������1���й���ǰ׺
        String[] strs1 = {"flower", "flow", "flight"};
        assertEquals("fl", solution.longestCommonPrefix(strs1));
        
        // ��������2���޹���ǰ׺
        String[] strs2 = {"dog", "racecar", "car"};
        assertEquals("", solution.longestCommonPrefix(strs2));
        
        // ��������3��������
        String[] strs3 = {};
        assertEquals("", solution.longestCommonPrefix(strs3));
        
        // ��������4�������ַ���
        String[] strs4 = {"hello"};
        assertEquals("hello", solution.longestCommonPrefix(strs4));
        
        // ��������5�������ַ�����ͬ
        String[] strs5 = {"test", "test", "test"};
        assertEquals("test", solution.longestCommonPrefix(strs5));
    }
}

