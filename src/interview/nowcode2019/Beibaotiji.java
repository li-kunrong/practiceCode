package interview.nowcode2019;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/12 8:50
 * @Description:
 **/
public class Beibaotiji {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = 0;
        int n = scanner.nextInt();
        int total = scanner.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        if (sum <= total) {
            System.out.println((int) Math.pow(2, n));
        } else {
            dfs(0, 0, n, nums, total);
            System.out.println(count + 1);
        }
    }

    static void dfs(long sum, int cur, int n, int[] nums, int total) {
        if (cur < n) {
            if (sum > total)
                return;
            dfs(sum, cur + 1, n, nums, total);
            if (sum + nums[cur] <= total) {
                count++;
                dfs(sum + nums[cur], cur + 1, n, nums, total);
            }
        }
    }
}
