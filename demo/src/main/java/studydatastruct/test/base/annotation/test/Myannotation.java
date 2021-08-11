package studydatastruct.test.base.annotation.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 44803
 * @title: Myannotation
 * @projectName hello-world
 * @description: TODO
 * @date 2020/5/1919:56
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Myannotation {
    String getannotation() default "annotation default";
}
