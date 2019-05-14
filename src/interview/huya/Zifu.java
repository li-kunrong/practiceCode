package interview.huya;

/**
 * @author kunrong
 * @description
 * @date 2019/4/22 21:03
 */
public class Zifu {
    public static void main(String[] args){
        int value = 128;
        Integer i1 = value;
        int i2 = value;
        Integer i3 = Integer.valueOf(value);
        Integer i4 = new Integer(value);
        System.out.println(i1==i3);
        System.out.println(i1==i2);
        System.out.println(i1==i4);
        System.out.println(i3==i4);
    }

    static void test_huya() {
        System.out.print("666");
        String s = new String("aaa");
        try {
            Class clazz = ClassLoader.getSystemClassLoader().loadClass("interview.huya.Test");
            clazz.forName("interview.huya.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
