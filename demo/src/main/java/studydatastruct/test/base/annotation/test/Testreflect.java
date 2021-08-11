package studydatastruct.test.base.annotation.test;

import java.lang.reflect.Field;

/**
 * @author wangkai
 * @create 2020/5/19
 */
public class Testreflect {

    public static void main(String[] args){
        try {
            Class<Testannotation> clazz = (Class<Testannotation>) Class.forName("studydatastruct.test.base.annotation.test.Testannotation");
            Myannotation myannotation = clazz.getAnnotation(Myannotation.class);
            try {
                Field field = clazz.getField("name");
                Object o = field.get(new Testannotation("2312"));
                Myannotation myannotationf = field.getAnnotation(Myannotation.class);
                System.out.println(myannotationf.getannotation());
                System.out.println(o.toString());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            String a = myannotation.getannotation();
            System.out.println(a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
