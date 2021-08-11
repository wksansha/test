package studydatastruct.test.base.threadlocal;

/**
 * @author wangkai
 * @create 2020/6/19
 */
public class ThreadLocalExsample {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    public void set() {
        longLocal.set(Thread.currentThread().getId());
    }
    public long getLong() {
        return longLocal.get();
    }
    public static void main(String[] args) {
        ThreadLocalExsample test = new ThreadLocalExsample();
        //注意:没有set之前，直接get，报null异常了
        System.out.println("-------threadLocal value-------" + test.getLong());
    }
}
