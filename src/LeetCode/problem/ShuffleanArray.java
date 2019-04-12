package LeetCode.problem;

public class ShuffleanArray {
    private int[] num;
    public static void main(String[] args){
           int a[] = {1,2,3,4};
           ShuffleanArray shuffleanArray = new ShuffleanArray(a);
        System.out.println(shuffleanArray.shuffle());
        System.out.println(shuffleanArray.reset());
        System.out.println(shuffleanArray.shuffle());
    }

    public ShuffleanArray(int[] nums) {
        this.num = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return num;
    }

    /** Returns a random shuffling of the array.
     * 巧妙，
     * */
    public int[] shuffle() {
        int rand[] = new int[num.length];
        for (int j = 0; j < num.length; j++){
            int r = (int) (Math.random() * (j+1));
            rand[j] = rand[r];
            rand[r] = num[j];
        }
        return rand;
    }
}
