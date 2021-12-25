//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 894 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new LinkedList<>();
        boolean[] visited;
        public List<List<Integer>> permuteUnique(int[] nums) {
            LinkedList<Integer> track = new LinkedList<>();
            visited = new boolean[nums.length];
            Arrays.sort(nums);
            backTrace(nums, track);
            return result;
        }

        public void backTrace(int[] nums, LinkedList<Integer> track) {
            if (nums.length == track.size()) {
                result.add(new LinkedList<>(track
                ));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i-1]))
                    continue;
                track.add(nums[i]);
                visited[i] = true;
                backTrace(nums, track);
                visited[i] = false;
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}