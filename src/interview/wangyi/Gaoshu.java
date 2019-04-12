package interview.wangyi;

import java.util.Scanner;

/**
 * @author kunrong
 * @description
 * @date 2019/3/29 14:22
 */
public class Gaoshu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int max = 0;
        int tmp =0;
        int know[] = new int[n+1];
        int isWake[] = new int[n+1];
        for (int i = 0; i < n; i++)
            know[i] =scanner.nextInt();
        for (int i = 0; i < n; i++)
            isWake[i] = scanner.nextInt();

        for (int i = 0; i < n; i++){
            if (isWake[i]==1) {
                tmp +=know[i];
            }
        }
        max = tmp;
        int benlai = tmp;
        for (int i = 0; i < n; i++) {

            if (isWake[i] == 0){
                for (int j = i; j <i+k&& j<n;j++){
                    if (isWake[j]==0){
                        tmp+=know[j];
                    }
                }
                if (tmp>max)
                    max= tmp;
                if (k>n-i){
                    break;
                }
                tmp= benlai;
            }

        }
        System.out.println(max);



    }
}
