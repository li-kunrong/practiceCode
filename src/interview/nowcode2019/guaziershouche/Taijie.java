package interview.nowcode2019.guaziershouche;

import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 9:51
 * @Description:
 **/
public class Taijie {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        calculateVolume(a,n);
    }

    static int calculateVolume(int arrays[],int length){

        int max=0;
        int max_pos = 0;
        for (int i=0;i<length;i++)
        {
            if (max<arrays[i])
            {
                max=arrays[i];
                max_pos=i;
            }
        }
        int max_left=0;
        int max_right=0;
        int volume=0;
        for(int i=0;i<max_pos;i++){
            if (max_left<arrays[i])
            {
                max_left=arrays[i];
            }
            else{
                volume+=(max_left-arrays[i]);
            }
        }
        for(int j=length-1;j>max_pos;j--){
            if (max_right<arrays[j])
            {
                max_right=arrays[j];
            }
            else{
                volume+=(max_right-arrays[j]);
            }
        }

        return volume;
    }
}
