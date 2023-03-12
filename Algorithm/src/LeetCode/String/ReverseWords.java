package LeetCode.String;

/**
 * 翻转字符串里的单词
 * <p>
 * 按着正常的英文句子 删除多余的空格
 * "  hello world!   "
 * "a good   example"
 * "are you ok"
 *
 * 核心思想：
 * ① 消除字符串中多余的空格
 * ② 字符串整体逆序
 * ③ 以空格分隔符 对每个单词进行逆序
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        // 消除多余空格
        int cur = 0, len = 0;
        // 默认是第一次假设遇到的第一个就是空格 下面的代码直接跳过了 不执行
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != ' ') {
                chars[cur++] = c;
                space = false;
            } else if (space == false) { // 当次c为空格 且上一次不是空格
                chars[cur++] = ' ';
                space = true;
            }
        }
        // 如果最后一个是空格还会再走一步 所以有效的字符长度为cur-1
        len = space ? (cur - 1) : cur;
        if (len <= 0) return null;

        // 翻转字符串
        reverse(chars, 0, len);

        // 对字符串中的每个单词进行逆序
        int prevSpaceIdx = -1; // 假设最初第一个空格是在数组-1的位置
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            reverse(chars, prevSpaceIdx + 1, i);
            prevSpaceIdx = i;
        }
        // 对最后一个单词进行翻转
        reverse(chars, prevSpaceIdx + 1, len);
        return new String(chars, 0, len);
    }

    // 对[l, r)范围内字符进行逆序
    private void reverse(char[] chars, int l, int r) {
        // 因为[l, r)所以需要做减1才能取得值
        r--;
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {

    }

}
