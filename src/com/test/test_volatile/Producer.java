package com.test.test_volatile;

/**
 * @author kunrong
 * @date 2019/3/11 13:16
 */
public class Producer implements Runnable{
    private volatile boolean flag = false;

    public Producer(boolean flag) {
        this.flag = flag;
    }

    public Producer() {
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while(!flag){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
