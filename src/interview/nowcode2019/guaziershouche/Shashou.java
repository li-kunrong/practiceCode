package interview.nowcode2019.guaziershouche;

/**
 * @Author: kunrong
 * @Date: 2019/8/16 10:30
 * @Description:
 **/
public class Shashou {
    public static void main(String[] args) {
        int a[] = new int[1001];
        for (int i = 1; i <=1000; i++) {
            a[i] = i;
        }
        int kill = 0;
        int k = 1;
        boolean flag = true;
        while (kill<999) {
            if(a[k]==0) {
                k%=1000;
                k++;
                continue;
            }
            if (flag==true) {
                flag = false;
                k%=1000;
                k++;
                continue;
            }else {
                flag = true;
                a[k] = 0;
                k%=1000;
                k++;
                kill++;
            }
        }
        for (int i = 1;i <=1000; i++) {
            if (a[i]!=0){
                System.out.println(i);
            }
        }
    }
}
