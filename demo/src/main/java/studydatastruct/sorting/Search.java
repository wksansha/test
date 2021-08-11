package studydatastruct.sorting;


/**
 * @author wangkai
 * @create 2019/12/11
 */
public class Search {
    //在不存在重复元素的有序数组中，查找值等于给定值的元素
    public static int bSearch(int a[],int b){
        int i = 0;
        int j = a.length-1;
        while (i<=j){
            int mid = i+((j-i)>>1);
            if (a[mid] == b){
                return mid;
            }else if(a[mid] < b){
                i = mid + 1;
            }else{
                j = mid -1;
            }
        }
        return -1;
    }
    //查找第一个值等于给定值的元素
    public static int fSearch(int a[],int b){
        int i = 0;
        int j = a.length-1;
        while (i<=j){
            int mid = i+((j-i)>>1);
            if (a[mid] == b){
                if ((mid == 0) || (a[mid - 1] != b)) return mid; else j = mid - 1;
            }else if(a[mid] < b){
                i = mid + 1;
            }else{
                j = mid -1;
            }
        }
        return -1;
    }
    //查找最后一个值等于给定值的元素
    public static int lSearch(int a[],int b){
        int i = 0;
        int j = a.length-1;
        while (i<=j){
            int mid = i+((j-i)>>1);
            if (a[mid] == b){
                if ((mid == a.length-1) || (a[mid + 1] != b)) return mid; else i = mid + 1;
            }else if(a[mid] < b){
                i = mid + 1;
            }else{
                j = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int sourceArray[] = {4,4,4,8,9};
        int temp = fSearch(sourceArray,4);
        System.out.println(temp);
    }
}
