package interview.erfen;

/**
 * @Author: kunrong
 * @Date: 2019/8/15 15:39
 * @Description:
 **/
public class First {
    public static void main(String[] args) {
      //  int a[] = {1,2,2,2,2,3};
        int a[] ={4,5,6,7,0,1,2};
      //  System.out.println(first(a,2));
      //  System.out.println(second(a,2));
        System.out.println(findRotateMin(a));
    }

    /**
     * 找相同元素最大index
     * @param a
     * @param target
     * @return
     */
    static int first(int[]a, int target) {
        int left = 0;
        int n = a.length;
        int right = n-1;
        int mid = 0;
        while (left+1<right) {
            mid = left+(right-left)/2;
            if (a[mid]<=target){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;

    }

    /**
     * 找相同元素最小index
     * @param a
     * @param target
     * @return
     */
    static int second(int a[], int target) {
        int left = 0;
        int n = a.length;
        int right = n-1;
        int mid = 0;
        while (left+1<right) {
            mid = left+(right-left)/2;
            if (a[mid]>=target){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;

    }

    /**
     * 旋转数组的最小值
     * @param a
     * @return
     */
    static int findRotateMin(int []a) {
        int start = 0;
        int end = a.length-1;
        while (start+1<end) {
            int mid = start+(end-start)/2;
            if (a[mid]<=a[end]){
                end = mid;
            }else {
                start = mid;
            }
        }
        if (a[start]<a[end])
            return a[start];
        return a[end];
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (target > nums[end]) {
                if (nums[mid] > target || nums[mid] <= nums[end]) {
                    end = mid;
                } else if (nums[mid] == target) {
                    return mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] > nums[end] || nums[mid] < target) {
                    start = mid;
                } else if (nums[mid] == target) {
                    return mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
