/**
 * @Auther: Administrator
 * @Date: 2018/9/22 08:16
 * @Description:
 */

import java.util.concurrent.BlockingQueue;

/**
 * 消费者线程
 */
public class Consumer implements Runnable {

    private BlockingQueue<String> queue;
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println("启动消费者线程！");

        boolean isRunning = true;

        while (isRunning) {
            String data = null;
            try {
                Thread.sleep(2000);
                data = queue.take();
                System.out.println("正在消费数据：" + data);
            } catch (InterruptedException e) {
                System.out.println("无消息可用");
            }

        }
    }
}



