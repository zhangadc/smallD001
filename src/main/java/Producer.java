/**
 * @Auther: Administrator
 * @Date: 2018/9/22 08:14
 * @Description:
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者线程
 */
public class Producer implements Runnable {

    private volatile boolean isRunning = true;
    private BlockingQueue queue;
    private static AtomicInteger count = new AtomicInteger();

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        String data = null;
        System.out.println("启动生产者线程！");
        int count2 = 0;
        while (count2<50) {
            data = "data:" + count.incrementAndGet();
            System.out.println("将数据：" + data + "放入队列...");
            try {
                count2++;
                queue.put(data);
                System.out.println(queue.size());
            } catch (InterruptedException e) {
                System.out.println("队列已满等待中···");
            }
        }

    }
}
