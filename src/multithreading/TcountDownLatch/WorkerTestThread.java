package multithreading.TcountDownLatch;

import java.util.concurrent.CountDownLatch;

public class WorkerTestThread implements Runnable{
    private Worker worker;
    private CountDownLatch cdLatch;

    public WorkerTestThread(Worker worker, CountDownLatch cdLatch) {
        this.worker = worker;
        this.cdLatch = cdLatch;
    }
    @Override
    public void run() {
        worker.doWork();        // 让工人开始工作
        cdLatch.countDown();    // 工作完成后倒计时次数减1
    }
}
