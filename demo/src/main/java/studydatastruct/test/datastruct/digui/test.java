package studydatastruct.test.datastruct.digui;

/**
 * @author wangkai
 * @create 2020/12/1
 */
import java.util.HashMap;

public class test {
    private static int count1=0;
    private static int count2=0;
    private static int count3=0;
    public static void main(String[] args) {
        System.out.println("***********************递归*********************");
        long startTime1=System.nanoTime();
        System.out.println(getNumber1(10));
        long endTime1=System.nanoTime();
        System.out.println("方法调用了"+count1+"次数");

        System.out.println("时间为："+(endTime1-startTime1)+"ns");
        System.out.println("***********************备忘录递归*********************");
        long startTime2=System.nanoTime();
        System.out.println(getNumber2(10));
        long endTime2=System.nanoTime();
        System.out.println("方法调用了"+count2+"次数");

        System.out.println("时间为："+(endTime2-startTime2)+"ns");
        System.out.println("***********************动态规划*********************");
        long startTime3=System.nanoTime();
        System.out.println(getNumber3(10));
        long endTime3=System.nanoTime();
        System.out.println("方法调用了"+count3+"次数");

        System.out.println("时间为："+(endTime3-startTime3)+"ns");

        System.out.println("***********************动态规划数组*********************");
        long startTime4=System.nanoTime();
        System.out.println(getNumber4(10));
        long endTime4=System.nanoTime();
        System.out.println("时间为："+(endTime4-startTime4)+"ns");
    }
    //递归
    //   832040
    //	方法调用了1664079次数
    //	时间为：4839154ns

    public static int getNumber1( int  m) {
        count1++;
        if(m==1||m==2)
        {
            return m;
        }
        else
            return getNumber1(m-1)+getNumber1(m-2);

    }

    // 备忘录算法，自上而下，记住之前算过的值。减少方法的访问次数从而减少运行时间
    //方法调用了：57
    //832040
    //时间为：133048ns
    private static HashMap<Integer, Integer> hm=new HashMap<>();
    public static int getNumber2( int  m) {
        count2++;
        if(m==1||m==2)
        {
            return m;
        }
        else if(hm.containsKey(m))
        {
            return hm.get(m);
        }
        else {
            int  value =getNumber2(m-1)+getNumber2(m-2);
            hm.put(m, value);
            return value;
        }
    }
    // 动态规划，自下向上的算法
    //方法调用了：1
    //时间为：3422ns
    //832040

    public static int getNumber3( int  m) {
        count3++;
        if(m==1||m==2)
        {
            return m;
        }
        int  a=1;
        int b=2;
        int temp=0;
        for(int x=3;x<=m;x++)
        {
            temp=a+b;
            a=b;
            b=temp;

        }
        return temp;
    }
    // 动态规划，自下向上的算法
    //方法调用了：1
    //时间为：3422ns
    //832040
    public static int getNumber4( int  m) {
        count3++;
        int[] num = new int[m];
        num[0] = 1;
        num[1] = 2;
        for(int i = 2;i<m;i++){
            num[i] =  num[i-1] + num[i-2];
        }
        return num[m-1];
    }
}
