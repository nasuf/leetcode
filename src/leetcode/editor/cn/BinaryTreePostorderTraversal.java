//给定一个二叉树，返回它的 后序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树


package leetcode.editor.cn;

import java.util.*;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 递归算法
         */
        /*public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            postorderTraversal(root, list);
            return list;
        }

        private void postorderTraversal(TreeNode root, List<Integer> list) {
            if (root != null) {
                postorderTraversal(root.left, list);
                postorderTraversal(root.right, list);
                list.add(root.val);
            } else {
                return;
            }
        }*/

        /**
         * 迭代算法
         */
        /*public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null) {
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    res.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return res;
        }*/

        /**
         * 先序遍历的逆序
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(0, node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}