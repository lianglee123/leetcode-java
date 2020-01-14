package joy.leetcode;

public class BinaryIndexedTree {
    int size;
    int[] table;
    public BinaryIndexedTree(int size) {
        table = new int[size];
        this.size = size;
    }

    void update(int i, int delta) {
        while (i < size) {
            table[i] += delta;
            i += Integer.lowestOneBit(i);
        }
    }

    int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += table[i];
        }
        return sum;
    }

    int rangeSum(int i, int j) {
        return sum(j) - sum(i);
    }
}
