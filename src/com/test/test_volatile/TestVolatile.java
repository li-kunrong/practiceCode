package com.test.test_volatile;

/**
 * @author kunrong
 * @date 2019/3/11 13:15
 */
public class TestVolatile {
    public static void main(String[] args) throws InterruptedException {
        Producer producer1 = new Producer();

        new Thread(producer1,"test1").start();
        Thread.sleep(2000);
        producer1.setFlag(true);
    }
}
