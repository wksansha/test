package studydatastruct.test.base.annotation.test;

/**
 * @author wangkai
 * @create 2020/5/19
 */
@Myannotation
public class Testannotation {

    @Myannotation(getannotation = "ddd")
    public String name;

    public void sayHello(){

    }
    public void sayDefault(){

    }
    public Testannotation(String name){
        this.name = name;
    }
}
