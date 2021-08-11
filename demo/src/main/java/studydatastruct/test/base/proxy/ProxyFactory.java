package studydatastruct.test.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangkai
 * @create 2020/6/8
 */
public class ProxyFactory {
    private Object  target;
    public ProxyFactory(Object  target){
        this.target = target;
    }
    int i = 0;

    public Object getProxyTarget(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println(proxy.getClass().getName());
            Method[] methods = proxy.getClass().getDeclaredMethods();
            for(Method m : methods){
                System.out.println(m.getName());
            }
            Object obj = method.invoke(target,args); //通过反射，调用目标对象的方法
            System.out.println(target.getClass().getName());
            return obj;
        });
    }
}
