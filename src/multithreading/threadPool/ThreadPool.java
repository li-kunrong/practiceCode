package multithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
      // new ThreadPool().newFixedThreadPool();
       new ThreadPool().newScheduleThreadPoll();
    }

    public void normal(){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦....");
            });
        }
    }
    public void newFixedThreadPool(){
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦....");
            });
        }
    }

    public void newScheduleThreadPoll() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.schedule(() -> {
                System.out.println(Thread.currentThread().getName() + "\t开始发车啦....");
            }, 10, TimeUnit.SECONDS);
        }
    }
}
