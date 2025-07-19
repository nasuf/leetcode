/**
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个 "LX" 替换一个 "XL"，
 * 或者用一个 "XR" 替换一个 "RX"。现给定起始字符串 start 和结束字符串 result，请编写代码，当且仅当存在一系列移动操作使得 start 可以
 * 转换成 result 时， 返回 True。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：start = "RXXLRXRXL", result = "XRLXXRRLX"
 * 输出：true
 * 解释：通过以下步骤我们可以将 start 转化为 result：
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：start = "X", result = "L"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= start.length <= 10⁴
 * start.length == result.length
 * start 和 result 都只包含 'L', 'R' 或 'X'。
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 300 👎 0
 */
package leetcode.editor.cn;

public class SwapAdjacentInLrString {
    public static void main(String[] args) {
        Solution solution = new SwapAdjacentInLrString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canTransform(String start, String result) {
            if (!start.replace("X", "").equals(result.replace("X", ""))) {
                return false;
            }
            int j = 0;
            int length = start.length();
            for (int i = 0; i < length; i++) {
                if (start.charAt(i) == 'X') {
                    continue;
                }
                while (result.charAt(j) == 'X') {
                    j++;
                }
                if (start.charAt(i) == 'L' && i < j) {
                    return false;
                } else if (start.charAt(i) == 'R' && i > j) {
                    return false;
                }
                j++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}