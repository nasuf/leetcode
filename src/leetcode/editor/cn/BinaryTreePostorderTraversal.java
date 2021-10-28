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

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /**
         * 递归算法
         */
        public List<Integer> postorderTraversal(TreeNode root) {
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
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}