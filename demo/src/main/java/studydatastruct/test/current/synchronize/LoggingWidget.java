package studydatastruct.test.current.synchronize;

/**
 * @author wangkai
 * @create 2020/8/28
 */
public class LoggingWidget extends Widget{

    /**
     * synchronized 内置锁 是一种 对象锁（锁的是对象而非引用变量），作用粒度是对象 ，可以用来实现对 临界资源的同步互斥访问 ，
     * 是 可重入 的。其可重入最大的作用是避免死锁
     * 一个线程在获取了锁之后，再次去获取了同一个锁不会死锁
     */
    public synchronized void doSomething () {
        System.out.println(this.toString()+ ": calling doSomething");
        super.doSomething();
    }

    public static void main (String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(() -> {
                Widget widget = new LoggingWidget();
                widget.doSomething();
            });
            thread.start();
        }
    }
}
