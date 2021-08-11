package studydatastruct.test.base.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;/**
 * join(long)释放锁
 *
 * @author Administrator
 *
 */
public class Demo4 extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(Demo4.class);

    public static void main(String[] args) throws InterruptedException {
        LOGGER.info("main start");
        final Demo4 demo4 = new Demo4();

        // 启动demo4线程并且占用锁之后调用join(long)方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (demo4) {
                        LOGGER.info("进入同步代码块，threadName ->{} 占有 demo4 的锁", Thread.currentThread().getName());
                        demo4.start();
                        demo4.join(4 * 10000);
                        LOGGER.info("退出同步代码块，threadName ->{}", Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "threadA").start();

        // 休眠2秒钟，调用对象的同步方法
        Thread.sleep(2 * 10000);
        demo4.test2();
    }

    @Override
    public void run() {
        try {
            LOGGER.info(Thread.currentThread().getName()+"开始执行");
            Thread.sleep(10 * 10000);
            LOGGER.info(Thread.currentThread().getName()+"结束执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test2() {
        LOGGER.info("进入test2方法，占有锁，threadname->{}", currentThread().getName());
    }
}
