package interview.nowcode;

/**
 * @author kunrong
 * @description
 * @date 2019/4/12 16:04
 */
public class TestString {
    public static void main(String[] args) {
        char []a = new char[10];
        for (int i = 0; i < 10; i++) {
            a[i] = (char) ('0'+i);
        }
        a[5] =0;
        System.out.println(String.valueOf(a));
    }
}
