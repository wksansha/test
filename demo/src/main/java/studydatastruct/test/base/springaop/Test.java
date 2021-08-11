package studydatastruct.test.base.springaop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkai
 * @create 2020/7/3
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        AspectJAfterAdvice aspectJAfterAdvice = new AspectJAfterAdvice();
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor();
        List<MethodInterceptor> methodInterceptors = new ArrayList<>();
        methodInterceptors.add(methodBeforeAdviceInterceptor);
        methodInterceptors.add(aspectJAfterAdvice);
        methodInterceptors.add(methodBeforeAdviceInterceptor);

        ReflectiveMethodInvocation reflectiveMethodInvocation = new ReflectiveMethodInvocation(methodInterceptors);
        reflectiveMethodInvocation.proceed();
    }
}
