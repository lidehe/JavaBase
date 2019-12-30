package CountDownLatch;

import utils.PropertyUtils;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class MyThread {

    public static final CountDownLatch countDownLatch=new CountDownLatch(Integer.parseInt(PropertyUtils.getThreadNum()));

    public void run() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (countDownLatch) {
                countDownLatch.countDown();
                if (countDownLatch.getCount() > 0) {
                    try {
                        countDownLatch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.notifyAll();
            }

            System.out.println(Thread.currentThread().getName() + " finish");
        });
        thread.start();
    }
}
