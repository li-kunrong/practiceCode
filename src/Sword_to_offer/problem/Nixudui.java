package Sword_to_offer.problem;

public class Nixudui {
    /**
     *
     *
     *  重点：归并排序时，每次左边大于右边的时候，增加的逆序数为mid-i+1;
     *  time = O(nlog n);
     a) 把长度为4的数组分解成两个长度为2的子数组；
     (b) 把长度为2的数组分解成两个成都为1的子数组；
     (c) 把长度为1的子数组 合并、排序并统计逆序对 ；
     (d) 把长度为2的子数组合并、排序，并统计逆序对；
     在上图（a）和（b）中，我们先把数组分解成两个长度为2的子数组，
     再把这两个子数组分别拆成两个长度为1的子数组。接下来一边合并相邻的子数组，
     一边统计逆序对的数目。在第一对长度为1的子数组{7}、{5}中7大于5，因此（7,5）组成一个逆序对。
     同样在第二对长度为1的子数组{6}、{4}中也有逆序对（6,4）。由于我们已经统计了这两对子数组内部的逆序对，
     因此需要把这两对子数组 排序 如上图（c）所示， 以免在以后的统计过程中再重复统计。
     */

    int cnt;
    public static void main(String[] args){
     int[] array = {10,9,8,7};
     new Nixudui().InversePairs(array);
    }

    public int InversePairs(int[] array) {
        cnt = 0;
        if (array != null)
            mergeSortUp2Down(array, 0, array.length - 1);
        return cnt;
    }

    /*
     * 归并排序(从上往下)
     */
    public void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;

        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    /*
     * 将一个数组中的两个相邻有序区间合并成一个
     */
    public void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                cnt += mid - i + 1;  // core code, calculate InversePairs............
            }
        }

        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }
}
