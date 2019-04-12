package LeetCode.method_of_bisection;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 *  The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 Example 1:

 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]

 Example 2:

 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]

 Note:

 The value k is positive and will always be smaller than the length of the sorted array.
 Length of the given array is positive and will not exceed 104
 Absolute value of elements in the array and x will not exceed 104

 UPDATE (2017/9/19):
 The arr parameter had been changed to an array of integers (instead of a list of integers).
 Please reload the code definition to get the latest changes.
 */
public class Find_K_Closest_Elements_658 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int k = 2;
        int x = 3;
        new Find_K_Closest_Elements_658().findClosestElements(a,k,x);
    }

    /**
     * 这个解法是直接从数组里通过二分法找到应为的subarray的start位置，
     * 通过判断mid位置和mid + k位置上与x的差值的大小比较来确定二分的update rule，因此时间复杂度更好
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int start = 0, end = arr.length-k;
        while(start<end){
            int mid = start + (end-start)/2;
            if(Math.abs(arr[mid]-x)>Math.abs(arr[mid+k]-x)){
                start = mid+1;
            } else {
                end = mid;
            }
        }
        for(int i=start; i<start+k; i++){
            res.add(arr[i]);
        }
        return res;
    }

    public List<Integer> findClosestElements_II(int[] arr, int k, int x) {
//        由于数组是有序的，所以最后返回的k个元素也一定是有序的，那么其实就是返回了原数组的一个长度为k的子数组，转化一下，
//        实际上相当于在长度为n的数组中去掉n-k个数字，而且去掉的顺序肯定是从两头开始去，应为距离x最远的数字肯定在首尾出现。
//        那么问题就变的明朗了，我们每次比较首尾两个数字跟x的距离，将距离大的那个数字删除，直到剩余的数组长度为k为止
        List<Integer> list =new ArrayList<Integer>();
        for (int i=0;i<arr.length;i++)
        {
            list.add(arr[i]);
        }
        while (list.size() > k) {
            int first  = 0, last = list.size() - 1;
            if (x - list.get(first) <= list.get(last) - x) {
                list.remove(last);
            } else {
                list.remove(first);
            }
        }
        return list;
    }
}
