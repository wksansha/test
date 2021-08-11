package studydatastruct.test.datastruct.linked;

/**
 * @author wangkai
 * @create 2021/1/26
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * •	实现单链表、循环链表、双向链表，支持增删操作
 * •	实现单链表反转
 * •	实现两个有序的链表合并为一个有序链表
 * •	实现求链表的中间结点
 */
public class TestLinked {
    private static ListNode<String> head = null;
    public static void add(String s) {
        ListNode<String> node = new ListNode<>(s);
        node.next = head;
        head = node;
        printAll(head);
    }
        // 单链表反转
    private static ListNode reverse(ListNode node) {
        ListNode a = node;
        ListNode b = null;
        while (a != null){
            ListNode next = a.next;
            a.next = b;
            b = a;
            a = next;
        }
        return b;
    }
    // 单链表反转,其中m到n的节点（m<=n）
    private static ListNode reverse1(ListNode node,int left,int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = node;
        ListNode pre = dummyNode;
        ListNode cur = pre.next;
        ListNode next;
        int i = 1;
        while(cur.next != null){
            if(left <= i && i<right){
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }else if(i >=right){
                break;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
            i++;
        }
        return  dummyNode.next;
    }
    //实现两个有序的链表合并为一个有序链表
    private static ListNode merge(ListNode<String> a, ListNode<String> b){
        ListNode<String> newNode = new ListNode<>("0");
        ListNode<String> newNode1 = newNode;
        ListNode<String> p = a;
        ListNode<String> q = b;
        while (p != null && q!=null){
            if(Integer.parseInt(p.val) < Integer.parseInt(q.val)){
                newNode1.next = p;
                p = p.next;
            }else{
                newNode1.next = q;
                q = q.next;
            }
            newNode1 = newNode1.next;
        }
        if(p == null){
            newNode1.next = q;
        }
        if(q == null){
            newNode1.next = p;
        }
        return newNode.next;
    }
    //求链表的中间结点
    private static ListNode findMiddleNode(ListNode node){
        HashMap<Integer,ListNode> map = new HashMap<>();
        int i = 0;
        while (node != null){
            map.put(i,node);
            node = node.next;
            i++;
        }
        return (map.get(i/2));
    }
    private static ListNode findMiddleNode1(ListNode node){
        if(node == null){return null;}
        ListNode fast = node;
        ListNode slow = node;
        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 删除倒数第K个结点
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast !=null && i <k){
            fast = fast.next;
            ++i;
        }
        if(fast ==null){return list;}
        Node slow = list;
        Node pre = null;
        while (fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre == null){
            list = list.next;
        }else {
            pre.next = pre.next.next;
        }
        return list;
    }
    // 检测环
    public static boolean checkCircle(Node list) {
        Node fast = list;
        Node slow = list;
        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    //　判断是否为回文

    public static boolean palindrome(ListNode list){
        if(list == null){return false;}
        ListNode fast = list;
        ListNode slow = list;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p;
        ListNode q = null;
        if(fast != null){
            p = slow.next;
        }else{
            p = slow;
        }
        while (p != null){
            ListNode next = p.next;
            p.next = q;
            q = p;
            p = next;
        }
        while (q != null){
            if(q.val.equals(list.val)){
                q = q.next;
                list = list.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void printAll(ListNode p) {
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
      /*  Scanner sn  = new Scanner(System.in);
        int i = 6;
        while (i-->0) {
            if (sn.hasNextLine()) {
                add(sn.nextLine());
            }
        }
        ListNode<String> node = head;
        findMiddleNode(node);
        head = null;
        int j = 6;
        while (j-->0) {
            if (sn.hasNextLine()) {
                add(sn.nextLine());
            }
        }
        printAll(merge(node,head));*/
        String data[] = {"7","6","5","4","3","2","1"};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            add(data[i]);
        }
        printAll(reverse1(head,3,6));
    }
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
