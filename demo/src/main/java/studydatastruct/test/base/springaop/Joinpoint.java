package studydatastruct.test.base.springaop;

/**
 * @author 44803
 * @title: Joinpoint
 * @projectName hello-world
 * @description: TODO
 * @date 2020/7/313:29
 */
public interface Joinpoint {
    Object proceed() throws Throwable;
}
