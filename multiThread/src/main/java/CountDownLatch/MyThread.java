package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class MyThread {
    public static CountDownLatch countDownLatch;

    public void setCountDownLatch(int threadNum) {
        countDownLatch = new CountDownLatch(threadNum);
    }

    public void run() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " start");
            System.out.println(countDownLatch.getCount());
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
