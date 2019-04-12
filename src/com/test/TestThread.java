package com.test;

/**
 * @author kunrong
 * @date 2019/1/30 22:05
 */
public class TestThread {
    private Integer num = 10;

    public static void main(String[] args) {
        TestThread tests = new TestThread();
        tests.test();
    }

    public void reduce() {
        synchronized (num) {
            while (num > 0) {
                num--;
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(num);
                System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
            }

        }
    }


    public void test() {
        Thread a = new Thread() {
            @Override
            public void run() {
                super.run();
                reduce();
            }
        };

        Thread b =new Thread() {
            @Override
            public void run() {
                super.run();
                reduce();
            }
        };
        a.setName("A");
        b.setName("B");

        b.start();
        a.start();
    }
}
