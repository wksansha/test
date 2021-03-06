package studydatastruct.test.datastruct.queue;

/**
 * Created by wangzheng on 2018/10/9.
 */
// 用数组实现的队列
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 如果tail == n 表示队列已经满了
        if(tail == n){
            return false;
        }else {
            items[tail] = item;
            tail ++;
        }
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if(tail == head){
            return null;
        }else {
            return items[head++];
        }
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}