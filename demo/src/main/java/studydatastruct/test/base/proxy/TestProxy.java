package studydatastruct.test.base.proxy;

/**
 * @author wangkai
 * @create 2020/6/8
 */
public class TestProxy {
    public static void main(String[] args){
        Person p = new Man();
        Person proxyp = (Person) new ProxyFactory(p).getProxyTarget();
        System.out.println("返回代理类的实例："+proxyp.getClass().getName());
        proxyp.style("得快");
    }
}
