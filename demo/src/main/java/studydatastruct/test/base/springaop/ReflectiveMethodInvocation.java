package studydatastruct.test.base.springaop;

import java.util.List;

/**
 * 中间类，拦截器链调用逻辑
 * @author wangkai
 * @create 2020/7/3
 */
public class ReflectiveMethodInvocation  implements MethodInvocation{
    List<MethodInterceptor> methodInterceptors;

    public ReflectiveMethodInvocation(List<MethodInterceptor> methodInterceptors) {
        this.methodInterceptors = methodInterceptors;
    }

    private int index = -1;

    @Override
    public Object proceed() throws Throwable {
        Object var = null;
        if (index == this.methodInterceptors.size()-1) {
            System.out.println("真正的目标方法");
            return new String("ha");
        }else{
            var = methodInterceptors.get(++index).invoke(this);

        }

        return var;
    }

}
