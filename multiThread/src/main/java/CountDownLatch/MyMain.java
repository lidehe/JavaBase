package CountDownLatch;


import java.util.concurrent.CountDownLatch;

public class MyMain {

    public static void main(String[] args) {
        int threadNum = 10;
        MyThread myThread = new MyThread();
        myThread.setCountDownLatch(threadNum);
//        MyThread.countDownLatch=new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            MyThread myThreadInner = new MyThread();
            myThreadInner.run();
        }
    }
}
