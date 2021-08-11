package studydatastruct.test.datastruct.array;

/**
 * @author wangkai
 * @create 2020/7/29
 */

import java.util.Arrays;

/**
 * 实现两个有序数组合并为一个有序数组
 */
public class ResizeArray {

    private static int[] mergeArray(int[] a,int[] b){
        int[] c = new int[a.length + b.length];
        int k = 0;
        int j = 0;
        int i = 0;
        for(;i<a.length;i++){
            for(;j<b.length;j++){
                if(a[i] < b[j]){
                    c[k] = a[i];
                    k++;
                    break;
                }else{
                    c[k] = b[j];
                    k++;
                }
            }
            if(j==b.length){
                c[k] = a[i];
                k++;
            }
        }
        if(j < b.length-1){
           for(;j<b.length;j++){
               c[k] = b[j];
               k++;
           }
        }
        return c;
    }

    /**
     * 用两个指针
     * @param a
     * @param b
     * @return
     */
    private static int[] mergeArray1(int[] a,int[] b){
        int[] c = new int[a.length + b.length];
        int k = 0;
        int j = 0;
        int i = 0;
        while (i < a.length && j < b.length){
            if(a[i] < b[j]){
                c[k++] = a[i];
                i++;
            }else{
                c[k++] = b[j];
                j++;
            }
        }
        while(i < a.length ){
            c[k++] = a[i];
            i++;
        }
        while(j < b.length ){
            c[k++] = a[j];
            j++;
        }
        return c;
    }
    public static void main(String[] args) {
            int[] a = {1,2,3,4,5,10,11,12};
            int[] b = {2,3,4,5,8,9};
            int[] c = mergeArray1(a,b);
            System.out.println(Arrays.toString(c));
    }
}
