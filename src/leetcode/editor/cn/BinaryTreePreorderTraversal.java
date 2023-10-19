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
            List<Integer> result = new ArrayList<>();
            return preOrder(result, root);
        }

        public List<Integer> preOrder(List<Integer> result, TreeNode root) {
            if (null == root) {
                return result;
            }
            result.add(root.val);
            preOrder(result, root.left);
            preOrder(result, root.right);
            return result;
        }*/

        /**
         * 迭代算法
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (null == root) {
                return list;
            }
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                list.add(top.val);
                if (null != top.right) {
                    stack.push(top.right);
                }
                if (null != top.left) {
                    stack.push(top.left);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}