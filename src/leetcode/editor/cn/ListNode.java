package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(int[] vals) {
        PrimitiveIterator.OfInt iterator = Arrays.stream(vals).iterator();
        ListNode prev = new ListNode();
        ListNode p = prev;
        while (iterator.hasNext()) {
            prev.next = new ListNode(iterator.next());
            prev = prev.next;
        }
        return p.next;
    }
}