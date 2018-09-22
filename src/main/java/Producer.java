/**
 * @Auther: Administrator
 * @Date: 2018/9/22 08:14
 * @Description:
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者线程
 * @author Administrator
 */
public class Producer implements Runnable {

    private BlockingQueue<String> queue;
    private static AtomicInteger count = new AtomicInteger();

    Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
       // String data = null;
        System.out.println("启动生产者线程！");
        int count2 = 0;
        //定义范围
        int max = 50;
        while (count2<max) {
           String data = "data:" + count.incrementAndGet();
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
