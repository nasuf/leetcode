//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        /**
         * 递归算法
         */
        /*public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            return traverse(root, res);
        }

        public List<Integer> traverse(TreeNode root, List<Integer> res) {
            if (root == null) {
                return new ArrayList<>();
            }
            res.add(root.val);
            traverse(root.left, res);
            traverse(root.right, res);
            return res;
        }*/

        /**
         * 迭代算法
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (null != node.right) {
                    stack.push(node.right);
                }
                if (null != node.left) {
                    stack.push(node.left);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}