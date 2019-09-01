package interview.jingdong2019;

import java.util.*;

/**
 * @author kunrong
 * @description
 * @date 2019/8/24 20:06
 */
public class Kaochang {
    public static void main(String[] args){
        Scanner scanner =new Scanner( System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int guanxi[][] = new int[m][2];
        int a[] = new int[2*n+1];
        List<Integer> res = new ArrayList<>();
        for (int i=0;i  < m; i++) {
            guanxi[i][0] = scanner.nextInt();
            a[guanxi[i][0]]++;
            guanxi[i][1] = scanner.nextInt();
            a[guanxi[i][1]]++;
        }
        int record = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set =new HashSet<>();


        while (record<m) {
            int text = getF(a);
           // a[text] = 0;
            if (text==-1) {
                break;
            }else {
                res.add(text);
                for (int i= 0;i <m ;i++) {
                    if (guanxi[i][0]==text||guanxi[i][1]==text) {
                        a[guanxi[i][0]]--;
                        a[guanxi[i][1]]--;
                        record++;
                    }
                }
            }
        }

        Collections.sort(res);
        System.out.println(res.size());
        for (int i =0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }


    }

    static int getF(int a[]) {
        int res = Integer.MIN_VALUE;
        int b = 0;
        for (int i = 1; i <a.length; i++) {
            if (a[i]>res) {
                res = a[i];
                b = i;
            }
        }
        if (res==0) {
            return  -1;
        }else {
            return b;
        }
    }
}
