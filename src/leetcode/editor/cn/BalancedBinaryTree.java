//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树


package leetcode.editor.cn;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 自顶向下
         */
        /*public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            else
                return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int height(TreeNode root) {
            if (root == null)
                return 0;
            else
                return Math.max(height(root.left), height(root.right)) + 1;
        }*/

        /**
         * 自底向上
         */
        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }

        private int height(TreeNode root) {
            if (root == null)
                return 0;
            int left = height(root.left);
            if (left == -1)
                return -1;
            int right = height(root.right);
            if (right == -1)
                return -1;
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}