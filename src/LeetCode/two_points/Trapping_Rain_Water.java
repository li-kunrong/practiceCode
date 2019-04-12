package LeetCode.two_points;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 */
public class Trapping_Rain_Water {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int []left = new int [len];
        int []right = new int [len];
        left[0] = 0;
        left[len-1] = 0;
        int max = 0;
        int total = 0;
        //计算每一个左边最大的
        for (int i = 1; i < len ; i++) {
            left[i] = Math.max(max,height[i-1]);
            max = left[i];
        }
        max = 0;
        //计算每一个右边最大的
        for (int i = len-2; i >= 0; i--) {
            right[i] = Math.max(max,height[i+1]);
            max = right[i];
        }
        //把当前的高度与左右最大之间最小的作比较，比它小的就增加
        for (int i = 0; i < len ; i++) {
            int min = Math.min(left[i],right[i]);
            if (min > height[i]){
                total+=(min-height[i]);
            }
        }
        return total;
    }
}
