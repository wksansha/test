package studydatastruct.test.base.threadlocal;

/**
 * java中的sleep()和wait()的区别
 * @author Hongten
 * @date 2013-12-10
 */
public class TestD {

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main:"+(System.currentTimeMillis()-start));
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run(){
            synchronized (TestD.class) {
                System.out.println("enter thread1...");
                long start = System.currentTimeMillis();
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    TestD.class.wait();
                    System.out.println("Thread1:"+(System.currentTimeMillis()-start));//打印出时间间隔
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class Thread2 implements Runnable{
        @Override
        public void run(){
            synchronized (TestD.class) {
                long start = System.currentTimeMillis();
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                //TestD.class.notify();
                //==================
                //区别
                //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
                //方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(10000);
                  //  TestD.class.wait(3000);
                    System.out.println("Thread2:"+(System.currentTimeMillis()-start));//打印出时间间隔
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }System.out.println("thread2 is going on....");
            System.out.println("thread2 is over!!!");
        }
    }
}
