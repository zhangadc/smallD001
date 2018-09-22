

import java.util.concurrent.BlockingQueue;

/**
 * Consumer
 * @author Administrator
 * @Date: 2018/9/22 08:16
 * @Description:消费者线程
 */
public class Consumer implements Runnable {

    private BlockingQueue<String> queue;


    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
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



