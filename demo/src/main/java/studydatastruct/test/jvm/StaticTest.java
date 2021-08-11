package studydatastruct.test.jvm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangkai
 * @create 2020/7/16
 */
public class StaticTest {
    public static void main(String[] args) {
        String ss = getNumbers("顶楼");
        System.out.println(ss);
    }

    private static String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }
    static StaticTest st = new StaticTest();
    static {   //静态代码块
        System.out.println("1");
    }
    {       // 实例代码块
        System.out.println("2");
    }
    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }
    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }
    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量
}

