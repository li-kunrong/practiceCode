package LeetCode.two_points;

public class _73SortColor {
    /**
     * 方法一：直接计算每个颜色的个数，再覆盖
     * @param nums
     */
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {
                red++;
            }else if (nums[i] == 1){
                white++;
            }else if (nums[i] == 2) {
                blue++;
            }
        }
        for (int i = 0; i < red; i++){
            nums[i] = 0;
        }
        for (int i = red; i< (red+white); i++)  {
            nums[i] = 1;
        }
        for (int i = (red+white); i < (red+white+blue); i++){
            nums[i] = 2;
        }
    }

    /**
     * 方法二：双指针，遇到0，就和头部交换，遇到1 i++，遇到2和尾部交换。
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        for (int i = 0; i <= two; ) {
            if (nums[i] == 0 && i > zero) {
                swap(nums, i, zero++);
            } else if (nums[i] == 2 && i < two) {
                swap(nums, i, two--);
            } else {
                i++;
            }
        }
    }

    void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
