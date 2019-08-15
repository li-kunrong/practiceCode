package interview.wangyi2019;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: kunrong
 * @Date: 2019/8/6 15:14
 * @Description:
 **/
public class Duita {
    public static void main(String[] args) {
        List<Pair<Integer,Integer>> list =new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (n==1){
            System.out.println(0+" " + 0);
            return;
        }
        int b[] = new int[4];
        int m = 0;
        find(a,b);
        a[b[1]]--;
        a[b[3]]++;
        int s = b[0]-b[2];
        if (s==0) {
            System.out.println(0+" "+0);
        }
        if (k==0) {
            System.out.println(s+" " + 0);
        }
        Pair pair = new Pair(b[1]+1,b[3]+1);
        list.add(pair);
        --k;
        m++;

        while (s!=0&&k-->0) {
            find(a,b);
            s = b[0]-b[2];
           // System.err.println(s);
            a[b[1]]--;
            a[b[3]]++;
            Pair pair2 = new Pair(b[1]+1,b[3]+1);
            list.add(pair2);
            m++;
        }
        find(a,b);
        s = b[0]-b[2];
        System.out.println(s+" "+ m);
        for (int i = 0; i < list.size(); i++) {
            Pair pair1 = list.get(i);
            System.out.println(pair1.getKey()+" "+pair1.getValue());
        }


    }

    static void find(int []a, int []b) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i]>max) {
                max = a[i];
                maxIndex= i;
            }
            if (a[i]<min) {
                min = a[i];
                minIndex = i;
            }
        }
        b[0] = max;
        b[1] = maxIndex;
        b[2] = min;
        b[3] = minIndex;
    }

}

class Pair<K,V> implements Serializable {

    /**
     * Key of this <code>Pair</code>.
     */
    private K key;

    /**
     * Gets the key for this pair.
     * @return key for this pair
     */
    public K getKey() { return key; }

    /**
     * Value of this this <code>Pair</code>.
     */
    private V value;

    /**
     * Gets the value for this pair.
     * @return value for this pair
     */
    public V getValue() { return value; }

    /**
     * Creates a new pair
     * @param key The key for this pair
     * @param value The value to use for this pair
     */
    public Pair( K key,  V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * <p><code>String</code> representation of this
     * <code>Pair</code>.</p>
     *
     * <p>The default name/value delimiter '=' is always used.</p>
     *
     *  @return <code>String</code> representation of this <code>Pair</code>
     */
    @Override
    public String toString() {
        return key + "=" + value;
    }

    /**
     * <p>Generate a hash code for this <code>Pair</code>.</p>
     *
     * <p>The hash code is calculated using both the name and
     * the value of the <code>Pair</code>.</p>
     *
     * @return hash code for this <code>Pair</code>
     */
    @Override
    public int hashCode() {
        // name's hashCode is multiplied by an arbitrary prime number (13)
        // in order to make sure there is a difference in the hashCode between
        // these two parameters:
        //  name: a  value: aa
        //  name: aa value: a
        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }

    /**
     * <p>Test this <code>Pair</code> for equality with another
     * <code>Object</code>.</p>
     *
     * <p>If the <code>Object</code> to be tested is not a
     * <code>Pair</code> or is <code>null</code>, then this method
     * returns <code>false</code>.</p>
     *
     * <p>Two <code>Pair</code>s are considered equal if and only if
     * both the names and values are equal.</p>
     *
     * @param o the <code>Object</code> to test for
     * equality with this <code>Pair</code>
     * @return <code>true</code> if the given <code>Object</code> is
     * equal to this <code>Pair</code> else <code>false</code>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof javafx.util.Pair) {
            javafx.util.Pair pair = (javafx.util.Pair) o;
            if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
            if (value != null ? !value.equals(pair.getValue()) : pair.getValue() != null) return false;
            return true;
        }
        return false;
    }
}



