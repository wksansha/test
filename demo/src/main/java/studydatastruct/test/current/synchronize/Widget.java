package studydatastruct.test.current.synchronize;

/**
 * @author wangkai
 * @create 2020/8/28
 */
public class Widget {
    public synchronized void doSomething () {
        System.out.println(this.toString()+"---------------------");
    }
}
