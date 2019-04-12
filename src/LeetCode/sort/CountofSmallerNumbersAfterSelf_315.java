package LeetCode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf_315 {
    public static void main(String[] args){
        int num[] = {1,9,4,3};
        new CountofSmallerNumbersAfterSelf_315().countSmallerII(num);
    }
    int[] count;

    /**
     * 归并排序，当然是排索引的序，当有右边的小于左边的，rightcount++，
     * 大于的话count[]就+=rightcount
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        mergesort(nums, indexes, 0, nums.length - 1);
        for(int i = 0; i < count.length; i++){
            res.add(count[i]);
        }
        return res;
    }
    private void mergesort(int[] nums, int[] indexes, int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, end);
    }
    private void merge(int[] nums, int[] indexes, int start, int end){
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while(left_index <= mid && right_index <= end){
            if(nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;//why
                right_index++;
            }else{
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;//不明白
                left_index++;
            }
            sort_index++;
        }
        while(left_index <= mid){
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while(right_index <= end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for(int i = start; i <= end; i++){
            indexes[i] = new_indexes[i - start];
        }
    }

    /**
     * 以数组尾部的节点为首建立搜索二叉树，同时记录他们前面的个数和重复的个数，好方法。
     * timeOlog(n)
     * @param nums
     * @return
     */
    public List<Integer> countSmallerII(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insertNode(nums[i], root, i, 0, ans);
        }
        return Arrays.asList(ans);
    }

    Node insertNode(int val, Node node, int i, int prevSum, Integer[] ans) {
        if (node == null) {
            node = new Node(val, 0);
            ans[i] = prevSum;
        } else if (val == node.val) {
            node.dup += 1;
            ans[i] = prevSum + node.sum;
        } else if (val > node.val) {
            node.right = insertNode(val, node.right, i, prevSum + node.sum + node.dup, ans);
        } else {
            node.sum += 1;
            node.left = insertNode(val, node.left, i, prevSum, ans);
        }

        return node;
    }
}

class Node {
    int val;
    int sum;
    int dup = 1;
    Node left;
    Node right;

    public Node(int v, int s) {
        this.val = v;
        this.sum = s;
    }
}