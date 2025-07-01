//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 递归
         */
        /*public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            return traversal(root, res);
        }

        public List<Integer> traversal(TreeNode root, List<Integer> res) {
            if (root == null) {
                return res;
            }
            traversal(root.left, res);
            res.add(root.val);
            traversal(root.right, res);
            return res;
        }*/

        /**
         * 迭代
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }

        /**
         * Morris遍历
         */
        /*public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            TreeNode cur1 = root;
            TreeNode cur2 = null;
            while (cur1 != null) {
                cur2 = cur1.left;
                if (cur2 != null) {
                    while (cur2.right != null && cur2.right != cur1) {
                        cur2 = cur2.right;
                    }
                    if (cur2.right == null) {
                        cur2.right = cur1;
                        cur1 = cur1.left;
                        continue;
                    } else {
                        cur2.right = null;
                    }
                }
                list.add(cur1.val);
                cur1 = cur1.right;
            }
            return list;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}