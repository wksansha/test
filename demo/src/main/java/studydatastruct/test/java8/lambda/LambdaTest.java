package studydatastruct.test.java8.lambda;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class LambdaTest {

    /**
     * 在匿名内部类中需要访问局部变量，那么这个局部变量必须用final修饰符修饰
     * 为什么传递给匿名内部类的参数必须声明为final？
     * 局部变量在方法中，方法调用完毕即弹栈，会从内存消失。而匿名内部类的实例是在堆中，在未来某个时刻被垃圾回收。
     * 生命周期不同步会导致：一个实例持有一个已经不存在的变量引用
     * 如何解决生命周期不同步的问题呢？
     * 在底层将这个局部变量的值传入到了匿名内部类中，并且以匿名内部类的成员变量的形式存在，这个值的传递过程是通过匿名内部类的构造器完成的。
     * 这样有什么问题？
     * 无法保证变量的一致性。如果不用final修饰，一旦局部变量改变，但匿名内部类是不知道的，所以必须加final，保证变量值的一致性
     * @throws InterruptedException
     */
    @Test
    public void testClosure() throws InterruptedException {
        // 在匿名内部类的外面定义一个String变量
        final String str = "hello";
        //str = "ddd";
        // 构造一个匿名内部类对象
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(str);
            }
        };

        new Thread(r).start();

        TimeUnit.SECONDS.sleep(1);
    }

}