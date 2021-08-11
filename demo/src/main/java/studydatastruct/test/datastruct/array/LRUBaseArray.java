package studydatastruct.test.datastruct.array;


import java.util.Scanner;

/**
 * @author wangkai
 * @create 2020/4/14
 */
public class LRUBaseArray<T> {
    private Integer capacity;
    private Integer count;
    private T[] value;


    public LRUBaseArray(Integer capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
    }
    public void add(T data){
        int i = finddata(data);
        if(i >= 0){
            for(;i>0;i--){
                value[i] = value[i-1];
            }
        }else{
            if(count >= capacity){
                count --;
            }
           for(int j = count;j>0;j--){
               value[j] = value[j-1];
           }
            count ++;
        }
        value[0] = data;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
    private int finddata(T data) {
        for(int i = 0; i< count;i++){
            if(value[i].equals(data)){
                return i;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        LRUBaseArray list = new LRUBaseArray(4);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.next());
            System.out.print(list.toString());
        }
    }
}
