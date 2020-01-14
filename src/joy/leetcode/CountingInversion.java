package joy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountingInversion {
    // 使用Merge排序法解决：https://www.youtube.com/watch?v=AeyUmjk4HGQ
    class Item {
        int val;
        int index;
        public Item(int v, int i) {
            val = v;
            index = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }
        int[] count = new int[n];
        mergeSort(items, 0, n - 1, count);
        List<Integer> res = new ArrayList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void mergeSort(Item[] items, int lo, int hi, int[] count) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(items, lo, mid, count);
        mergeSort(items, mid+1, hi, count);
        merge(items, lo, mid, mid+1, hi, count);
    }

    private void merge(Item[] items, int left, int leftEnd, int right, int rightEnd, int[] count) {
        int m = rightEnd - left + 1;
        Item[] sorted = new Item[m];
        int leftPtr = left, rightPtr = right;

        int inversionCounter = 0;  // 记录右边比左边小的情况的个数
        int index = 0;
        while (leftPtr <= leftEnd && rightPtr <= rightEnd) {
            Item itemL = items[leftPtr];
            Item itemR = items[rightPtr];
            if (itemR.val < itemL.val) {
                inversionCounter++;   // 这里的加不仅仅是为itemL加，而是为整个itemL队列加， 大数的逆序数，一定是小数的逆序数加上只属于大数的逆序数
                sorted[index] = itemR;
                rightPtr++;
            } else {
                count[itemL.index] += inversionCounter;  // 此时itemL的逆序个数已经确定了。
                sorted[index] = itemL;
                leftPtr++;
            }
            index++;
        }

        // 处理队列剩余的情况
        // 左队列剩余, 在左队列中的item的逆序数，等于此时inversionCounter
        while (leftPtr <= leftEnd) {
            Item itemL = items[leftPtr];
            count[itemL.index] += inversionCounter;
            sorted[index] = items[leftPtr];
            index++;
            leftPtr++;
        }

        while (rightPtr <= rightEnd) {
            sorted[index] = items[rightPtr];
            index++;
            rightPtr++;
        }

        System.arraycopy(sorted, 0, items, left, m);
    }

    public static void main(String[] args) {
        CountingInversion c = new CountingInversion();
        int[] nums = {5, 2, 6, 1};
        List<Integer> r = c.countSmaller(nums);
        System.out.println(r);
    }
}
