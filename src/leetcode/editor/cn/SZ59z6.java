//「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
//给定一棵二叉树 `root` 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
//
//
//**示例 1：**
//>输入：`root = [1,3,2,1,null,2]`
//>
//>输出：`3`
//>
//>解释：焰火中有 3 个不同的颜色，值分别为 1、2、3
//
//**示例 2：**
//>输入：`root = [3,3,3]`
//>
//>输出：`1`
//>
//>解释：焰火中仅出现 1 个颜色，值为 3
//
//**提示：**
//- `1 <= 节点个数 <= 1000`
//- `1 <= Node.val <= 1000`
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 
// 👍 3 👎 0


package leetcode.editor.cn;

import java.util.*;

public class SZ59z6 {
    public static void main(String[] args) {
        Solution solution = new SZ59z6().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int numColor(TreeNode root) {
            Set<Integer> set = new TreeSet<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            if (root == null) {
                return set.size();
            }
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                set.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}