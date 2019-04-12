package interview.JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo {
    public static void main(String[] args) {

//        AtomicDemo ad = new AtomicDemo();
        AtomicDemoII ad = new AtomicDemoII();
        for (int i = 0; i < 100; i++) {
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable {
    private int serialNumber = 0;

    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber++;
    }
}

class AtomicDemoII implements Runnable{

    private AtomicInteger serialNumber = new AtomicInteger();

    public void run(){
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){

        }

        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
    }

    public int getSerialNumber(){
        // 自增运算
        return serialNumber.getAndIncrement();
    }
}
