//翻转一棵二叉树。
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 递归算法
         */
        /*public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }*/

        /**'
         * 迭代算法
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode top = queue.poll();
                TreeNode left = top.left;
                top.left = top.right;
                top.right = left;
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}