//给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先） 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释： 
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2,null,0,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 2 到 5000 之间。 
// 0 <= Node.val <= 105 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 107 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        Solution solution = new MaximumDifferenceBetweenNodeAndAncestor().new Solution();
        /**
         *        8
         *     3    10
         *    1 6     14
         *      4 7  13
         *
         *
         */
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);
        solution.maxAncestorDiff(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int res = 0;
        public int maxAncestorDiff(TreeNode root) {
            preOrder(root, root.val, root.val);
            return res;
        }

        public void preOrder(TreeNode root, int min, int max) {
            if (root == null) {
                return;
            }
            res = Math.max(res, Math.max(Math.abs(root.val - min), Math.abs(max - root.val)));
            min = Math.min(root.val, min);
            max = Math.max(root.val, max);
            preOrder(root.left, min, max);
            preOrder(root.right, min, max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}