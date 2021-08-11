package studydatastruct.test.base.proxy;

/**
 * @author wangkai
 * @create 2020/6/8
 */
public class Man implements Person{
    @Override
    public String run(String name) {
        System.out.println("跑"+name);
        return "还好";
    }

    @Override
    public void style(String name) {
        System.out.println("风格"+name);
    }
}
