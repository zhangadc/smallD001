import java.util.concurrent.*;

public class T0 {

    public static void main(String[] args) {
        BlockingDeque<String> list = new LinkedBlockingDeque<>(20);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            threadPool.execute(new Producer(list));

           // threadPool.shutdown();
        }
        for (int i = 0; i < 5; i++) {
            threadPool.execute(new Consumer(list));
        }

    }

}

