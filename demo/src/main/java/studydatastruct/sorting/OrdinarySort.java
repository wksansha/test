package studydatastruct.sorting;
import java.util.Arrays;
import java.util.Random;

/**
 * @author wangkai
 * @create 2019/12/4
 */
public class OrdinarySort {

    /**
     * 生成随机数组
     * @return
     */
    public static int[] generateArray(){
        int length = 1000000;
        Random r = new Random(1);
        int[] arr = new int[length];
        for(int i = 0;i<length;i++){
            int temp = r.nextInt(length);
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * 程序执行时间
     * @param name
     * @param time
     */
    public static void runTime(String name,long time){
        System.out.print(name+"执行时间为：");
        System.out.println(System.currentTimeMillis()-time+"毫秒");
    }

    /**
     * 冒泡排序
     * @param sourceArray
     * @return
     */
    public static int[] bubbleSort(int[] sourceArray){
        long time = System.currentTimeMillis();//获取当前系统时间(毫秒)
        int length = sourceArray.length;
        if(length < 2){
            return sourceArray;
        }
        for(int i = 0;i<sourceArray.length;i++){
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for(int j = 0;j<sourceArray.length-1-i;j++){
                if(sourceArray[j] > sourceArray[j+1]){
                    int temp = sourceArray[j];
                    sourceArray[j] = sourceArray[j+1];
                    sourceArray[j+1] = temp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) break; // 没有数据交换，提前退出
        }
        runTime("冒泡排序",time);
        return sourceArray;
    }

    /**
     * 插入排序
     * @param sourceArray
     */
    public static void insertSort(int[] sourceArray){
        long time = System.currentTimeMillis();//获取当前系统时间(毫秒)
        int length = sourceArray.length;
        if(length < 2){
            return;
        }
        for(int i = 1;i<length;i++){
            int trmp = sourceArray[i];
            int j = i-1;
            for(;j>=0;j--){
                if(trmp < sourceArray[j]){
                    sourceArray[j+1] = sourceArray[j];
                }else{
                    break;
                }
            }
            sourceArray[j+1] = trmp;
        }
       // System.out.println(Arrays.toString(sourceArray));
        runTime("插入排序",time);
    }

    /**
     * 选择排序
     * @param sourceArray
     */
    public static void selectionSort(int[] sourceArray){
        long time = System.currentTimeMillis();//获取当前系统时间(毫秒)
        int length = sourceArray.length;
        if(length < 2){
            return;
        }
        for(int i =0;i<length;i++){
            int minIndex  = i;
            for(int j = i;j<length-1;j++){
                if(sourceArray[j+1] < sourceArray[minIndex]){
                    minIndex  = j+1;
                }
            }
            if(minIndex != i){
                int temp = sourceArray[i];
                sourceArray[i] = sourceArray[minIndex];
                sourceArray[minIndex] = temp;
            }
        }
        //System.out.println(Arrays.toString(sourceArray));
        runTime("选择排序",time);
    }

    /**
     * 希尔排序
     * @param sourceArray
     */
    public static void shellSort(int[] sourceArray){
        long time = System.currentTimeMillis();//获取当前系统时间(毫秒)
        int length = sourceArray.length;
        if(length < 2){
            return;
        }
        for(int step = length/2;step>0;step = (step-2)/4){
            for(int i = step;i<length;i++){
                int j;
                int trmp = sourceArray[i];
                for(j = i-step;j>=0 && trmp<sourceArray[j];j=j-step){
                    sourceArray[j+step] = sourceArray[j];
                }
                sourceArray[j+step] = trmp;
            }
        }
        //System.out.println(Arrays.toString(sourceArray));
        runTime("希尔排序",time);
    }

    /**
     * 快速排序
     * @param sourceArray
     */
    private static void quickSort(int[] sourceArray){
        long time = System.currentTimeMillis();//获取当前系统时间(毫秒)
        int length = sourceArray.length;
        if(length < 2){
            return;
        }
        quickSortInternally(sourceArray,0,length-1);
       // System.out.println(Arrays.toString(sourceArray));
        runTime("快速排序",time);
    }
    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

       // System.out.println("i=" + i);
        return i;
    }

    /**
     * 归并排序
     */
    private static void mymergeSort(int[] sourceArray){
        long time = System.currentTimeMillis();//获取当前系统时间(毫秒)
        int length = sourceArray.length;
        mergeSort(sourceArray,0,length-1);
        System.out.println(Arrays.toString(sourceArray));
        runTime("归并排序",time);
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int q = (left + right) / 2;
        mergeSort(arr, left, q);
        mergeSort(arr, q + 1, right);
        merge2(arr, left, q, right);

    }

    private static void merge2(int[] arr, int left, int q, int right) {
        int[] leftArr = new int[q - left + 2];
        int[] rightArr = new int[right - q + 1];

        for (int i = 0; i <= q - left; i++) {
            leftArr[i] = arr[left + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - left + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < right - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[right - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = left;
        while (k <= right) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }
    public static void main(String[] args) {
        int sourceArray[] = {4,5,3,8,9,6};
        //bubbleSort(generateArray());
       // insertSort(generateArray());
        //selectionSort(generateArray());
        //shellSort(generateArray());
       // quickSort(generateArray());
        mymergeSort(sourceArray);
        //System.out.println(Arrays.toString(sourceArray));
    }
}
