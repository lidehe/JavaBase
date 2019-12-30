package CountDownLatch;


import utils.PropertyUtils;

import java.util.concurrent.CountDownLatch;

public class MyMain {

    public static void main(String[] args) {
        int threadNum = Integer.parseInt(PropertyUtils.getThreadNum());
        for (int i = 0; i < threadNum; i++) {
            MyThread myThreadInner = new MyThread();
            myThreadInner.run();
        }
    }
}
