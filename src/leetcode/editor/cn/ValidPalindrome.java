//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串


package leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome(""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int j = s.length() - 1;
            for (int i = 0; i < s.length(); i++) {
                if (i == j) return true;
                if (Character.isLetterOrDigit(s.charAt(i))) {
                    while (!Character.isLetterOrDigit(s.charAt(j))) {
                        j--;
                    }
                    if (Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(s.charAt(j))) {
                        j--;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    continue;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}