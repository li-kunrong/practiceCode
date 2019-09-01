package test.interview;

/**
 * @author kunrong
 * @description
 * @date 2019/4/16 20:58
 */
public class Singleton {
    private static volatile  Singleton singleton;

    public static synchronized Singleton getSingleton() {
        if (singleton!=null) {
            synchronized (Singleton.class) {
                if (singleton!=null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
