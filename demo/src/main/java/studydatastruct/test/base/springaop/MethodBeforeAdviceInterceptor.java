package studydatastruct.test.base.springaop;

/**
 * @author wangkai
 * @create 2020/7/3
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("I am BeforeAdvice");
        return mi.proceed();
    }
}
