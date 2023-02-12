package leetcode.editor.cn;

public class Weekly6354 {
    public static void main(String[] args) {
        Weekly6354 weekly6354 = new Weekly6354();
        System.out.println(weekly6354.cal(new int[]{5}));
    }

    public long cal(int[] nums) {
        long ret = 0L;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i - 1 < i) {
                return ret;
            } else if (i != nums.length - i - 1) {
                String s = String.valueOf(nums[i]) + String.valueOf(nums[nums.length - i - 1]);
                long l = Long.parseLong(s);
                ret += l;
            } else {
                ret += nums[i];
            }
        }
        return ret;
    }
}
