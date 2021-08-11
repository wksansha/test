package studydatastruct.test.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangkai
 * @create 2021/1/3
 */
public class Demo {
    public static void main(String[] args) {
       /* String str1 = "abc";
        String str2 = "abcd";

        int i = compareString(str1, str2, Comparator.comparingInt(String::length));

        int[] out = new int[]{4,5,6};
        test(out);
        System.out.println(out[0]);
        System.out.println(out[1]);
        System.out.println(out[2]);
        test1(out);
        System.out.println(out[0]);
        System.out.println(out[1]);
        System.out.println(out[2]);
        int x = 10;
        test(x);
        System.out.println(x);*/
    }

    /**
     *java是值传递
     * @param out
     * @return
     */
    public static void test(int[] out){
        out = new int[]{1,2,3};
    }
    private static void test1(int[] x){
        x[0] = 9;
    }
    public static void test(int x){
        x = 5;
    }
    private static int compareString(String str1, String str2, Comparator<String> comparator) {
        return comparator.compare(str1, str2);
    }
}
