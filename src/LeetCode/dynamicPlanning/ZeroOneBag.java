package LeetCode.dynamicPlanning;

/**
 * @author kunrong
 * @description 01背包， 最重要的是
 * @date 2019/3/19 10:31
 */
public class ZeroOneBag {
    //分别定义宝物名称、重量、法力和背包最大容量
    public static String[] name = {"A","B","C","D","E"};
    public static int[] weight = {2,2,6,5,4};
    public static int[] value = {6,3,5,4,6};
    public static int  content = 10;

    public static void main(String[] args){
        int[][] arr = new int[name.length+1][content+1];
        for (int i = 1; i < name.length+1; i++) {
            for (int j = 1 ; j < arr[i].length; j++) {
                if (j >= weight[i-1]) {
                    arr[i][j] = Math.max(arr[i-1][j-weight[i-1]]+value[i-1], arr[i-1][j]);
                }else {
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        show(arr);
    }

    public static void show(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < content+1;j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
