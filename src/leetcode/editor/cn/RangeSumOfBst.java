//给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
//输出：32
// 
//
// 示例 2： 
//
// 
//输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 2 * 104] 内 
// 1 <= Node.val <= 105 
// 1 <= low <= high <= 105 
// 所有 Node.val 互不相同 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 256 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RangeSumOfBst {
    public static void main(String[] args) {
        Solution solution = new RangeSumOfBst().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, low, high, list);
            return  (int)list.stream().mapToInt(e -> e).summaryStatistics().getSum();
        }

        public void inOrder(TreeNode root, int low, int high, List<Integer> list) {
            if (root != null) {
                if (root.val >= low)
                    inOrder(root.left, low, high, list);
                if (root.val >= low && root.val <= high)
                    list.add(root.val);
                if (root.val <= high)
                    inOrder(root.right, low, high, list);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}