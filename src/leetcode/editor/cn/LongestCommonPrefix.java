//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String ret = "";
            if (strs.length == 0) return ret;
            String min = strs[0];
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < min.length())
                    min = strs[i];
            }

            for (int i = 0; i < min.length(); i++) {
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].charAt(i) == min.charAt(i))
                        continue;
                    else
                        return ret;
                }
                ret += min.charAt(i);
            }

            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}