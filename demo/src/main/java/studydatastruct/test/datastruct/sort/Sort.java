package studydatastruct.test.datastruct.sort;

/**
 * @author wangkai
 * @create 2021/3/20
 */
public class Sort {
    /**
     * 冒泡排序
     *
     * @param a
     */
    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     *
     * @param a
     */
    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i; j < a.length - 1; j++) {
                if (a[index] > a[j + 1]) {
                    index = j + 1;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }

    /**
     * 希尔排序
     *
     * @param a
     */
    private static void shellSort(int[] a) {
        int n = a.length;
        for (int i = n / 2; i > 0; i = i / 2) {
            for (int j = i; j < a.length; j++) {
                int value = a[j];
                int k = j - i;
                for (; k >= 0; k = k - i) {
                    if (a[k] > value) {
                        a[k + i] = a[k];
                    } else {
                        break;
                    }
                }
                a[k + i] = value;
            }
        }
    }

    /**
     * 归并排序
     *
     * @param a
     */
    private static void mymergeSort(int[] a) {
        mergeSort(a,0,a.length-1);
    }

    private static void mergeSort(int[] a, int left, int right) {
        if(left >= right){
            return;
        }
        int q = (left + right) / 2;
        mergeSort(a,left,q);
        mergeSort(a,q+1,right);
        merge(a,left,q,right);
    }
    private static void merge(int[] a, int left,int q, int right){
        int[] leftArr = new int[q-left+2];
        int[] rightArr = new int[right-q+1];
        for(int i = 0;i<q-left+1;i++){
            leftArr[i] = a[left+i];
        }
        leftArr[q-left+1] = Integer.MAX_VALUE;
        for(int j = 0;j<right-q;j++){
            rightArr[j] = a[q+1+j];
        }
        rightArr[right-q] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int k = left;
        while (k <= right){
            if(leftArr[i] < rightArr[j]){
                a[k++] = leftArr[i++];
            }else{
                a[k++] = rightArr[j++];
            }
        }
    }

    /**
     * 快速排序
     * @param a
     */
    private static void quickSort(int[] a) {
        quickSort1(a,0,a.length-1);
    }
    private static void quickSort1(int[] a,int p,int q) {
        if(p>=q){
            return;
        }
        int i = quickSort2(a,p,q);
        quickSort1(a,p,i-1);
        quickSort1(a,i+1,q);
    }
    private static int quickSort2(int[] a,int p,int q) {
        int left = p;
        int value = a[q];
        for(int k = p;k<q;k++){
            if(a[k] < value){
                if(left ==k){
                    left++;
                }else{
                    int temp = a[k];
                    a[k] = a[left];
                    a[left++] = temp;
                }
            }
        }
        a[q] = a[left];
        a[left] = value;
        return left;
    }
    private static int topk(int k,int[]a){
        return topk1(a,0,a.length-1,k);
    }

    private static int topk1(int[] a, int p, int q, int k) {
        if(p>q){
            return -1;
        }
        int mid = topk2(a,p,q);
        if(mid +1 == k){
            return a[mid];
        }else if(mid +1 < k){
            return topk1(a,mid +1,q,k);
        }else{
            return topk1(a,p,mid -1,k);
        }
    }

    private static int topk2(int[] a, int p, int q) {
        int i = p;
        int value = a[q];
        for(int j =p;j<q;j++){
            if(a[j] > value){
               if(i==j){
                   i++;
               }else{
                   int temp = a[i];
                   a[i++] = a[j];
                   a[j] = temp;
               }
            }
        }
        a[q] = a[i];
        a[i] = value;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {2,2,1};
        System.out.println(topk(2,a));
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}