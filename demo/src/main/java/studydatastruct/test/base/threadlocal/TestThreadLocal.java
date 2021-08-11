package studydatastruct.test.base.threadlocal;

/**
 * @author wangkai
 * @create 2020/6/19
 */
public class TestThreadLocal {
    //创建两个ThreadLocal实例并指定泛型，分别存储Long/String类型数据
    private static final ThreadLocal<Long> longLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> stringLocal = new ThreadLocal<>();

    //set方法，因为只是内部调用，用了private
    private void set(int i) {
        System.out.println(Thread.currentThread().getName()+"id:"+Thread.currentThread().getId());
        longLocal.set(Thread.currentThread().getId()+i);
        stringLocal.set(Thread.currentThread().getName()+i);
    }

    //get方法
    private long getLong() {
        return longLocal.get();
    }

    //get方法
    private String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        //------main线程执行开始--------
        final TestThreadLocal test = new TestThreadLocal();

        test.set(1);
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread = new Thread(() -> {
            //-------Thread-0线程执行开始--------
            for(int i = 0;i<10;i++){
                test.set(i);
            }
            System.out.println(test.getLong());
            System.out.println(test.getString());
            //-------Thread-0线程执行结束--------
        });
        thread.start();
        //thread.join():用来指定当前主线程等待其他线程执行完毕后,再来继续执行Thread.join()后面的代码
        thread.join();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        //------main线程执行结束--------
    }
}
