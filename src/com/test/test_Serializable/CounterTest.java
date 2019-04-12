package com.test.test_Serializable;

/**
 * @author kunrong
 * @description
 * 5个线程实现同步计数器
 * @date 2019/4/11 15:16
 */
public class CounterTest  {
    private   int count = 0;

    public static void main(String[] args){
        CounterTest test = new CounterTest();
        Counter counter = test.new Counter();
        for (int i = 0; i < 5; i++) {
            new Thread(counter).start();
        }
    }

    class  Counter  implements Runnable{
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (count<1000)
                        count++;
                    else
                        break;
                    System.out.println(Thread.currentThread().getName()+": count"  + count);
                }

                Thread.yield();//测试时线程更容易切换
            }
        }
    }

}
