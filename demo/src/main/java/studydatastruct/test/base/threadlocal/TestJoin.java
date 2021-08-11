package studydatastruct.test.base.threadlocal;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: Blank
 * Date: 14-3-28
 * Time: 下午7:49
 */
public class TestJoin {

    /**
     *  t.join() 会调用t.wait()方法,会释放线程t的锁即t线程中的currentThread()。同时，唤醒时，需要获取线程t的锁（t线程中的currentThread()）才可以唤醒当前线程
     * t.join() 方法其实是t.join(无穷大) 即等待线程t执行完毕后，唤醒当前线程
     * t.join(1000) 最多等待线程t执行1000ms后，如果线程t执行500ms就完毕，则完毕后立即唤醒当前线程
     * @param sure
     * @throws InterruptedException
     */
    public static void main(String[] sure) throws InterruptedException {
        Thread t = new Thread(() ->{
            //synchronized (TestJoin.class) {
            synchronized (currentThread()) {
                System.out.println(currentThread().getName()+"TestJoin begin");
                for (int i = 1; i <= 5; i++) {
                    try {
                        sleep(3000);//睡眠3秒，循环是为了方便输出信息
                        //currentThread().wait(5000);//睡眠5秒，循环是为了方便输出信息
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("睡眠" + i);
                }
                System.out.println("TestJoin finished");//t线程结束
            }
        });
        long start = System.currentTimeMillis();
        t.start();
        t.join(2000);//等待线程t 2000毫秒
       /* synchronized(TestJoin.class){
            t.start();
            t.join(2000);//等待线程t 2000毫秒
        }*/
        System.out.println(currentThread().getName());
        System.out.println(System.currentTimeMillis()-start);//打印出时间间隔
        System.out.println("Main finished");//打印主线程结束
    }
}
