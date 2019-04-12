package interview.kmp;

/**
 * @author kunrong
 * @date 2018/12/8 20:30
 */
public class Kmp {
    public static void main(String[] args){
        String s = "ABCDABDCE";
        String a = "ABCABCDABDCE";
        Kmp k = new Kmp();

        int next[] = k.getNext(s);

        int result = k.kmpSearch(a,s,next);
        System.out.println(result);
    }

    int kmpSearch(String a,String b, int[] next) {
        int i  = 0;
        int j = 0;
        int slen = a.length();
        int plen = b.length();
        char s[] = a.toCharArray();
        char p[] = b.toCharArray();
        while (i < slen && j < plen) {
            if (j == -1 || s[i]== p[j]) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j==plen) {
            return i-j;
        }
        return -1;
    }


     int[] getNext(String s) {
        int []next = new int[s.length()];
        next[0] = -1;
        int k = -1;
        int j  = 0;
        char p[] = s.toCharArray();
        while (j < p.length-1) {
            if (k==-1 || p[j] == p[k]) {
                ++j;
                ++k;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        for ( int i = 0; i< next.length; i++) {
            System.out.print(next[i] + " ");
        }
        return  next;
    }
}
