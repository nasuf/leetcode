/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 10⁴
 * s1 和 s2 仅包含小写字母
 * <p>
 * Related Topics 哈希表 双指针 字符串 滑动窗口 👍 649 👎 0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];
            for (int i = 0; i < n; ++i) {
                ++cnt1[s1.charAt(i) - 'a'];
                ++cnt2[s2.charAt(i) - 'a'];
            }
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
            for (int i = n; i < m; ++i) {
                ++cnt2[s2.charAt(i) - 'a'];
                --cnt2[s2.charAt(i - n) - 'a'];
                if (Arrays.equals(cnt1, cnt2)) {
                    return true;
                }
            }
            return false;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}