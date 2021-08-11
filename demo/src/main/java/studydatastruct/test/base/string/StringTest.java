package studydatastruct.test.base.string;


/**
 * @author wangkai
 * @create 2020/4/23
 */
public class StringTest {
    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];
    public static void main(String[]args){
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        String s5 = new String("1");
        String s6 = "1";
        s5.intern();
        System.out.println(s5 == s6);

        String s7 = new String("1") + new String("1");
        String s8 = "11";
        s7.intern();
        System.out.println(s7 == s8);
        String s9 = new String("1") + new String("1");
        String s10 = new String("2") + new String("2");
        String s11 = new StringBuilder("2").append("2").toString();
        String s12 = new String("ja") + new String("va");
        System.out.println( s9.intern() == s3);
        System.out.println( s9.intern() == s8);
        System.out.println( s9.intern() == s9);
        System.out.println( s10.intern() == s10);
        System.out.println( s11.intern() == s11);
        System.out.println( s12.intern() == s12);
    }
}
