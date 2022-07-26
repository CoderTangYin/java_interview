package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    /**
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(chars[0], 0);
        // i-1位置出现字符的最长不重复开始位置
        int li = 0;
        int maxLength = 1;
        for (int i = 0; i < chars.length; i++) {
            Integer pi = map.get(chars[i]);
            // 自己前一个字符出现的位置在自己第一次出现的左侧的情况
            // 自己前一个字符第一次出现的位置到自己出现的位置
            if (pi != null && li <= pi) {
                li = pi + 1;
            }
            map.put(chars[i], i);
            maxLength = Math.max(maxLength, i - li + 1);
        }
       return maxLength;
    }
}
