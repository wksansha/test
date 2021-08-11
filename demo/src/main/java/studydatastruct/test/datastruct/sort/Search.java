package studydatastruct.test.datastruct.sort;


/**
 * @author wangkai
 * @create 2021/03/30
 */
public class Search {
    //在不存在重复元素的有序数组中，查找值等于给定值的元素
    private static int bSearch(int a[],int b){
        int p = 0;
        int q = a.length-1;
        while (p<=q){
            int mid = p+((q-p)>>1);
            if(a[mid] == b){
                return mid;
            }else if(a[mid]< b){
                p = mid+1;
            }else{
                q = mid-1;
            }
        }
        return -1;
    }
    //查找第一个值等于给定值的元素
    private static int fSearch(int a[],int b){
        int p = 0;
        int q = a.length-1;
        while (p<=q){
            int mid = p+((q-p)>>1);
            if(a[mid] == b){
                if((mid == 0) || (a[mid - 1] != b)){
                    return mid;
                }else {
                    q = mid -1;
                }
            }else if(a[mid] < b){
                p = mid +1;
            }else{
                q = mid -1;
            }
        }
        return -1;
    }
    //查找最后一个值等于给定值的元素
    private static int lSearch(int a[],int b){
        int p = 0;
        int q = a.length-1;
        while (p<=q){
            int mid = p + ((q-p)>>1);
            if(a[mid] ==b){
                if(mid == a.length-1 || a[mid+1] !=b){
                    return mid;
                }else{
                    p = mid +1;
                }
            }else if(a[mid] < b){
                p = mid +1;
            }else{
                q = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int sourceArray[] = {1,2,2,2,9};
        int temp = lSearch(sourceArray,3);
        System.out.println(temp);
    }
}
