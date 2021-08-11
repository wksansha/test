package studydatastruct.test.base.springaop;

/**
 * @author wangkai
 * @create 2020/7/3
 */
public class AspectJAfterAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object var;
        try {
            var = mi.proceed();
        }finally {
            System.out.println("I am AfterAdvice");
        }
        return var;
    }
}
