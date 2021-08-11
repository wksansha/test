package studydatastruct.test.base.springaop;

/**
 * @author 44803
 * @title: MethodInterceptor
 * @projectName hello-world
 * @description: TODO
 * @date 2020/7/313:29
 */
public interface MethodInterceptor {
    Object invoke(MethodInvocation mi) throws Throwable;
}
