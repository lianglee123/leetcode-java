package joy.leetcode;

public class 逆序统计 {
    // 逆序统计: https://blog.csdn.net/jiange_zh/article/details/50698964
    public int inversePairsCount(int arr[], int l, int r) {
        if ((null == arr) || l>= r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        int left = inversePairsCount(arr, l, m);
        int right = inversePairsCount(arr, m+1, r);
        int bet = merge(arr, l, m, r);
        return left + right + bet;
    }

    public int merge(int arr[], int l, int m, int r) {
        int indexL = l;
        int indexR = m + 1;
        int indexTmp = 0;
        int cnt = 0;
        int[] tmp = new int[r-l+1];
        while (indexL <= m && indexR <= r) {
            if (arr[indexL] <= arr[indexR]) {
                tmp[indexTmp] = arr[indexL];
                indexTmp++;
                indexL++;
            } else {
                tmp[indexTmp] = arr[indexR];
                indexTmp++;
                indexR++;
                cnt += (m - indexL + 1);  // 加上L队列的所有数量。
            }
        }

        while (indexL <= m) {
            tmp[indexTmp++] = arr[indexL++];
        }

        while (indexR <= r) {
            tmp[indexTmp++] = arr[indexR++];
        }

        for (int i = l; i <= r; ++i) {
            arr[i] = tmp[i-l];
        }

        return cnt;
    }

    public static void main(String[] args) {
        逆序统计 a = new 逆序统计();
        int[] data = {7, 5, 6, 4};
        int r = a.inversePairsCount(data, 0, data.length-1);
        System.out.println(r);
    }
}
