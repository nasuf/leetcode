//计算给定二叉树的所有左叶子之和。
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树


package leetcode.editor.cn;

import org.w3c.dom.NodeList;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int sum = 0;

        /**
         * 注意叶子节点定义：左右子树均为null
         */
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}