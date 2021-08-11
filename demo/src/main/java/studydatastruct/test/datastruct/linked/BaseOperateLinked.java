package studydatastruct.test.datastruct.linked;

import java.util.Scanner;

/**
 * @author wangkai
 * @create 2020/4/14
 * 单链表回文串检测
 */
public class BaseOperateLinked {
    private int i ;
    private SNode<String> head = null;
    private boolean isPalindrome(){
        SNode<String> fast = head;
        SNode<String> slow = head;
        SNode<String> nodes = null;
        if(head == null || head.getNext() == null){
            return true;
        }
        while (fast != null && fast.getNext() != null ){
            fast = fast.getNext().getNext();
            SNode<String> next = slow.getNext();
            slow.setNext(nodes);
            nodes = slow;
            slow = next;
        }
        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            if (!slow.getElement().equals(nodes.getElement())) {
                return false;
            }
            slow = slow.getNext();
            nodes = nodes.getNext();
        }

        return true;
    }
    private void insertTail(String s){
        SNode<String> node = new SNode<>(s,null);
        if(head == null){
            head = node;
            return;
        }
        SNode<String> nodes = head;
        while (nodes.getNext()!=null){
            nodes = nodes.getNext();
        }
       // nodes.setNext(head.getNext().getNext());
        nodes.setNext(node);
    }
    private void insertToHead(String s){
        head = new SNode<>(s,head);
    }
    public void printAll(){
        SNode<String> node = head;
        while (node != null){
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
    }

    // 单链表反转
    public SNode<String> reverse() {
        SNode<String> list = head;
        SNode<String> target = null;
        while (list != null){
            SNode<String> next = list.getNext();
            list.setNext(target);
            target = list;
            list = next;
        }
        return target;
    }
    //链表中环的检测
    public void checkCircle(){
        SNode<String> node = head;
        if(head == null){
            System.out.println("该链表中没有环");
            return;
        }
        SNode<String> slow = node;
        SNode<String> fast = node.getNext();
        while (fast != null && fast.getNext() !=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                System.out.println("该链表中有环");
                return;
            }
        }
        System.out.println("该链表中没有环");
    }
    //求链表中间结点
    public SNode<String> findMiddleNode(){
        if(head == null){
            return null;
        }
        SNode<String> node = head;
        SNode<String> slow = node;
        SNode<String> fast = node.getNext();
        while (fast != null && fast.getNext() !=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
    //两个有序链表合并
    public SNode<Integer> findss(String[] s1,String[] s2){
        SNode<Integer> node1 = null;
        SNode<Integer> node2= null;
        for (String datum : s1) {
            node1 = new SNode<>(Integer.parseInt(datum),node1);
        }
        for (String datum : s2) {
            node2 = new SNode<>(Integer.parseInt(datum),node2);
        }
        SNode<Integer> soldier = new SNode<>(0,null);
        SNode<Integer> node = soldier;
        while (node1 != null && node2 != null){
            if(node1.getElement() <= node2.getElement()){
                node.setNext(node1);
                node1 = node1.getNext();
            }else{
                node.setNext(node2);
                node2 = node2.getNext();
            }
            node = node.getNext();
        }
        if(node1 == null){
            node.setNext(node2);
        }else{
            node.setNext(node1);
        }
        return soldier.getNext();

    }
    //递归实现两个有序链表合并
    public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode<Integer> head ;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
    //往头结点插入数据
    private ListNode<Integer> getNode(String[] s){
        ListNode<Integer> node = null;
        for (String datum : s) {
            ListNode<Integer>   node1 = new ListNode<>(Integer.parseInt(datum));
            node1.next = node;
            node = node1;
        }
        return node;
    }
    private ListNode<Integer> insertTail(String[] s){
        ListNode<Integer> node = new ListNode<>(0);
        ListNode<Integer> node1 = node;
        for (String datum : s) {
            node1.next = new ListNode<>(Integer.parseInt(datum));
            node1 = node1.next;
        }
        return node.next;
    }
    //删除链表倒数第n个结点
    public void deleteNode(ListNode<Integer> node,int n){
        ListNode<Integer> fast = node;
        ListNode<Integer> slow = node;
        for(int i = 1;i<n;i++){
            if(fast == null){
                System.out.println("xxx");
                return;
            }
            fast = fast.next;
        }
        if(fast.next == null){
            node = node.next;
        }else{
            while (fast.next.next != null){
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
        }
        while (node != null){
            System.out.print(node.val + ",");
            node = node.next;
        }

    }
    public static void main(String[]args){
       // String[] data = {"6","5","5","4"};
       // String[] data1 = {"7","4","1"};
        BaseOperateLinked link = new BaseOperateLinked();
       // for (String datum : data) {
        //    link.insertToHead(datum);
       // }
      //  link.insertTail("d");
       // System.out.println(link.isPalindrome());
       // link.reverse();
       // link.printAll();
       // link.checkCircle();
        //link.findss(data,data1);
        System.out.println(link.i);
        Scanner scanner = new Scanner(System.in);
        String[] sz = scanner.nextLine().split(" ");
        link.deleteNode(link.insertTail(sz),5);
    }
}
