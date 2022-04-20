/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 5 * 10⁴
 * s 包含可打印的 ASCII 字符。
 * s 不包含任何开头或结尾空格。
 * s 里 至少 有一个词。
 * s 中的所有单词都用一个空格隔开。
 * <p>
 * Related Topics 双指针 字符串 👍 433 👎 0
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        System.out.println(solution.reverseWords("God Ding"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] arr = s.split(" ");
            String[] ret = new String[arr.length];
            int index = 0;
            for(String str: arr) {
                char temp = 0;
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length / 2; i++) {
                    temp = chars[i];
                    chars[i] = chars[chars.length - 1 - i];
                    chars[chars.length - 1 - i] = temp;
                }
                ret[index] = new String(chars);
                index++;
            }
            return String.join(" ", ret);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}