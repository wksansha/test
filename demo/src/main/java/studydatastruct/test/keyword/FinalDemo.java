package studydatastruct.test.keyword;

/**
 * @author wangkai
 * @create 2021/1/3
 */


/**
 * 1.当用final修饰一个类时，表明这个类不能被继承,类中的所有成员方法都会被隐式地指定为final方法
 * 2.当用final修饰一个方法时,表明这个方法不能被重写，以防任何继承类修改它的含义.
 * 3.当用final修饰一个变量时，变量值（地址）不可修改。必须在定义时或者构造器中进行初始化赋值
 * 4.在多线程下:
 *   在构造函数内对一个 final 域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。
 *   初次读一个包含 final 域的对象的引用，与随后初次读这个 final 域，这两个操作之间不能重排序
 */
public class FinalDemo {
    private final int x;
    private int y;
    private static FinalDemo f;
    private FinalDemo() {
        x = 3;
        y = 4;
    }

    private static void writer() {
        f = new FinalDemo();
        //分配一块内存 M；
        // 在内存 M 上初始化 Singleton 对象；
        // 然后 M 的地址赋值给 instance 变量。
        // 但是实际上优化后的执行路径却是这样的：
        // 分配一块内存 M；
        // 将 M 的地址赋值给 instance 变量；
        // 最后在内存 M 上初始化 Singleton 对象。
    }

    private static void reader() {
        FinalDemo d = f;
        int i = d.x;
        int j = d.y;
        //i可以确保一定为3，j不能确保一定为4，因为此时可能还没有初始化Singleton 对象
        System.out.println("i="+i+"j="+j);

    }
    public static void main(String[] args) {
        new Thread(FinalDemo::writer).start();
        new Thread(FinalDemo::reader).start();
    }
}
