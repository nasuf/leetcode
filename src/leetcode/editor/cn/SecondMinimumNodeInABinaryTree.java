//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 241 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        solution.findSecondMinimumValue(root);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            int min = root.val;
            int secMin = -1;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();
                int levelSecMin = Integer.MAX_VALUE;
                for (int i = 1; i <= currentLevelSize; ++i) {
                    TreeNode node = queue.poll();
                    if (node.val != min) {
                        levelSecMin = Math.min(node.val, levelSecMin);
                        secMin = secMin == -1 ? levelSecMin : Math.min(levelSecMin, secMin);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
            }
            return secMin;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}