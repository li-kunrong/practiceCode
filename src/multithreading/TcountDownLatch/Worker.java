package multithreading.TcountDownLatch;

public class Worker {
    private String name;        // 名字
    private long workDuration;  // 工作持续时间

    /**
     * 构造器
     */
    public Worker(String name, long workDuration) {
        this.name = name;
        this.workDuration = workDuration;
    }

    /**
     * 完成工作
     */
    public void doWork() {
        System.out.println(name + " begins to work...");
        try {
            Thread.sleep(workDuration); // 用休眠模拟工作执行的时间
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(name + " has finished the job...");
    }
}
