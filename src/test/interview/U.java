package test.interview;

/**
 * @author kunrong
 * @description
 * @date 2019/4/14 21:51
 */
public class U {
    public static void main(String[] args){
        int a[] = {3,3,3,3,3,3};
        int b = 6;
        int res[] = new int[20];
        res= U.getIndexII(a,b);
        for (int i: res) {
            System.out.println(i);
        }
    }
    static int[] getIndex (int a[], int b) {
        int res[]  = new int[2];
        int i = 0;
        int l  = 0;
        int r = a.length-1;
        while (l<=r) {
            if (a[l] +a[r] == b){
                res[i++] = a[l];
                res[i++] = a[r];
                break;
            }else if(a[l]+a[r]>b){
                r--;
            }else {
                l++;
            }
        }
        return res;
    }

    static int getSum(int[] s, int n) {

        if (s== null || s.length==0) {
            return -1;
        }

        int sum =0 ;
        for (int i = 0; i <n; i++) {
            sum+=s[i] * Math.pow(3,n-i-1);
        }
        return sum;
    }

   static int[] getIndexII (int[] a, int b) {
        int res[] = new int[(a.length-1)*(a.length)];
        if (a==null || a.length==0) {
            return res;
        }
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] + a[j] == b) {
                    res[k++] = i;
                    res[k++] = j;
                }
            }
        }
        return res;
   }
}
