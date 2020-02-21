//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<String, String> standard = new HashMap<>();
            standard.put(")", "(");
            standard.put("]", "[");
            standard.put("}", "{");
            Stack<Character> stack = new Stack<>();
            if (s.length() >= 1) {
                stack.push(s.charAt(0));
                for (int i=1; i < s.length(); i++) {
                    if (null == standard.get(String.valueOf(s.charAt(i))) || stack.isEmpty()) {
                        stack.push(s.charAt(i));
                    } else if (standard.get(String.valueOf(s.charAt(i)))
                            .equals(String.valueOf(stack.peek()))
                    ) {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
                if (stack.isEmpty())
                    return true;
                else
                    return false;
            } else if (s.length() == 1) {
                return false;
            } else {
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}