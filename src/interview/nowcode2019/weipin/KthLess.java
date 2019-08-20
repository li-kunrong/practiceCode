package interview.nowcode2019.weipin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 15:53
 * @Description:
 **/
public class KthLess {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int u = s.nextInt();
        int n = s.nextInt();
        int a[] = new int[n*n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i*n+j] =s.nextInt();
            }

        }
        Arrays.sort(a);
        System.out.println(a[u-1]);
    }

    //方法1，二分套二分，时间复杂度O(n*logn*logn)
    public static int findKthNum(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[row - 1][col - 1];
        int mid = 0;
        int count = 0;
        while (low <= high) {
            count = 0;
            mid = low + ((high - low) >> 1);
            for (int[] item : matrix) {
                count += binarySearchCount(item, mid);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //返回的low表示满足count >= k的最小的数，这个数就是要找的第k个数
        return low;
    }

    public static int binarySearchCount(int[] data, int k) {
        int begin = 0, end = data.length - 1;
        int mid = 0;
        while (begin <= end) {
            mid = begin + ((end - begin) >> 1);
            if (data[mid] <= k) { //这里要加上等于k的
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        //全大于、全小于k都是begin，正好对应上了
        //这里返回的begin表示<=k的数的个数
        return begin;
    }

    //方法2，快排思想，把二维压成1维，用partion来找第k大的数，复杂度O(n^2)，对比还是第一种方法复杂度低一些
    //但是如果用排序了，对n^2的数据排序复杂度最小为O(n^2*log(n^2))
    public static int findKthNum1(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] arr = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i * col + j] = matrix[i][j];
            }
        }
        int begin = 0, end = arr.length - 1;
        int pos;
        while (begin <= end) {
            pos = partition(arr, begin, end);
            if (pos == k - 1) {
                return arr[pos];
            } else if (pos > k - 1) {
                end = pos - 1;
            } else {
                begin = pos + 1;
            }
        }
        return 0;
    }

    public static int partition(int[] arr, int begin, int end) {
        int temp = arr[begin];
        while (begin < end) {
            while (begin < end && arr[end] >= temp) {
                end--;
            }
            swap(arr,begin,end);
            while (begin < end && arr[begin] < temp) {
                begin++;
            }
            swap(arr,begin,end);
        }
        return begin;
    }
    public static void swap(int[]arr,int i,int j){
        if (arr == null || i >= arr.length || j >= arr.length || i < 0 || j < 0) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
