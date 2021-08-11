package studydatastruct.test.datastruct.linked;

import java.util.Scanner;

/**
 * @author wangkai
 * @create 2020/4/13
 */
public class LRUBaseLinkedList<T> {
    private Integer capacity;
    private Integer length;
    private SNode<T> headNode;

    private LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data){
        SNode node = findNode(data);
        if(node != null){
            deletNode(node);
            addNode(data);
        }else{
            if(length >= capacity){
                deletLastNode();
            }
            addNode(data);
        }
    }

    private void deletLastNode() {
        SNode<T> node = headNode;
        // 空链表直接返回
        if (node.getNext() == null) {
            return;
        }
        while (node.getNext().getNext() != null){
            node = node.getNext();
        }
        node.setNext(null);
        length --;
    }

    private void addNode(T data) {
        SNode noden = new SNode();
        noden.setElement(data);
        noden.setNext(headNode.getNext());
        headNode.setNext(noden);
        length ++;
    }
    private void deletNode(SNode node) {
        SNode noden = node.getNext();
        node.setNext(noden.getNext());
        length --;
    }

    private SNode findNode(T data) {
        SNode<T> node = headNode;
        while (node.getNext() != null){
            if(node.getNext().getElement().equals(data)){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }
    private void printAll(){
        SNode<T> node = headNode;
        while (node.getNext() != null){
            System.out.print(node.getNext().getElement() + ",");
            node = node.getNext();
        }
    }
    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList(4);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.next());
            list.printAll();
        }
    }
}
