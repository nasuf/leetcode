/**
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更
 * 新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= key, value <= 10⁶
 * 最多调用 10⁴ 次 put、get 和 remove 方法
 * <p>
 * <p>
 * Related Topics 设计 数组 哈希表 链表 哈希函数 👍 349 👎 0
 */
package leetcode.editor.cn;

import java.util.Iterator;
import java.util.LinkedList;

public class DesignHashmap {
    public static void main(String[] args) {
//        Solution solution = new DesignHashmap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {

        private class Pair {
            private int key;
            private int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        private static final int BASE = 769;
        private LinkedList<Pair>[] data;

        public MyHashMap() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                data[i] = new LinkedList<>();
            }
        }

        public void put(int key, int value) {
            int hash = hash(key);
            Iterator<Pair> iterator = data[hash].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }
            data[hash].offerLast(new Pair(key, value));
        }

        public int get(int key) {
            int hash = hash(key);
            Iterator<Pair> iterator = data[hash].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key){
                    return pair.getValue();
                }
            }
            return -1;
        }

        public void remove(int key) {
            int hash = hash(key);
            Iterator<Pair> iterator = data[hash].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    data[hash].remove(pair);
                    return;
                }
            }
        }

        private static int hash(int key) {
            return key % BASE;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}