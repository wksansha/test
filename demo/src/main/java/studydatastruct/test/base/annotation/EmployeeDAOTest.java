package studydatastruct.test.base.annotation;

/**
 * @author wangkai
 * @create 2020/5/19
 */
public class EmployeeDAOTest {
    @MyBefore
    public void init(String ss) {
        System.out.println("初始化..."+ss);
    }

    @MyAfter
    public void destroy() {
        System.out.println("销毁...");
    }

    @MyTest
    public void testSave() {
        System.out.println("save...");
    }

    @MyTest
    public void testDelete() {
        System.out.println("delete...");
    }
}
