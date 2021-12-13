//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -104 <= root.val <= 104 
// -104 <= subRoot.val <= 104 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 
// 👍 607 👎 0


package leetcode.editor.cn;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        /**
         * [3,4,5,1,2]
         * [4,1,2]
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        /*root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);*/

        TreeNode subRoot = new TreeNode(1);
        /*subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);*/

        System.out.println(solution.isSubtree(root, subRoot));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return false;   // if root == null, means root tree iteration is down while all failed.
            } else if (root.val == subRoot.val && isSameTree(root, subRoot)) {
                return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
            } else {
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            }
        }

        public boolean isSameTree(TreeNode root, TreeNode subRoot) {
            return (root == subRoot) ||
                    (root != null && subRoot != null
                            && root.val == subRoot.val && isSameTree(root.left, subRoot.left)
                            && isSameTree(root.right, subRoot.right)
                    );
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}