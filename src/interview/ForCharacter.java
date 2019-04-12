package interview;

/**
 * 问题一：
 *个多线程的问题，用三个线程，顺序打印字母A-Z，输出结果是1A 2B 3C 1D 2E…打印完毕最后输出一个Ok。
 */
public class ForCharacter {
    private static char c = 'A';
    private static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            public void run() {
                int threadId = Integer.parseInt(Thread.currentThread().getName());
                while(i < 26){
                    if(i % 3 == threadId - 1){
                        System.out.println("线程id：" + threadId + " " + (char)c++);
                        i++;
                        if(i == 26)
                            System.out.println("哈哈，祝拿到offer！");
                    }
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(r, "1");
        Thread t2 = new Thread(r, "2");
        Thread t3 = new Thread(r, "3");
        t1.start();
        t2.start();
        t3.start();
    }
    /**
     * 但是代码一存在问题：这样写的话，可能会造成资源浪费，
     * 所以我们可以通过加锁进行限制，但是加锁后，因为sleep不会释放锁,
     * 会导致其他线程无法获得执行机会。因此需要配合wait和notifyAll。
     */
    public static void main2() throws InterruptedException {
        Runnable r = new Runnable() {
            public void run() {
                synchronized (this) {
                    try {
                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        System.out.println("当前线程id：" + threadId + " ");
                        while (i < 26) {
                            if (i % 3 == threadId - 1) {
                                System.out.println("线程id：" + threadId + " " + (char) c++);
                                i++;
                                if (i == 26)
                                    System.out.println("哈哈，祝拿到offer！");
                                notifyAll();// 唤醒其他线程
                            } else {
                                wait();// 阻塞其他线程
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(r, "1");
        Thread t2 = new Thread(r, "2");
        Thread t3 = new Thread(r, "3");
        t1.start();
        t2.start();
        t3.start();
    }
}
