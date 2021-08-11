package studydatastruct.test.datastruct.digui;

/**
 * @author wangkai
 * @create 2021/3/17
 */
/**
 *  编程实现斐波那契数列求值f(n)=f(n-1)+f(n-2)
 *  编程实现求阶乘n!
 *  编程实现一组数据集合的全排列
 */
public class Demo {

    /**
     * 编程实现斐波那契数列求值f(n)=f(n-1)+f(n-2)
     * @param n
     * @return
     */
    private static int getValue(int n){
        if(n ==1 || n ==2){
            return n;
        }
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for(int i = 2;i<a.length;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }
    /**
     * 编程实现求阶乘n!
     * @param n
     * @return
     */
    private static int getValue1(int n,int type){
        switch (type){
            case 1:
                int[] a = new int[n];
                a[0] = 1;
                for(int i = 1;i<a.length;i++){
                    a[i] = (i+1) * a[i-1];
                }
                return a[n-1];
            case 2:
                int temp = 1;
                for(int x = 2;x<=n;x++){
                    temp = x*temp;
                }
                return temp;
            case 3:
                if(n == 1){
                    return n;
                }
                return n*getValue1(n-1,3);
        }
        return 0;
    }
    public static void main(String args[]){
        int a = getValue1(5,3);
        System.out.println(a);

    }
}
