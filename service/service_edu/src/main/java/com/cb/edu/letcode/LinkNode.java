package com.cb.edu.letcode;

public class LinkNode {
    int val;
    LinkNode next;


    public LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }

    public LinkNode(int val) {
        this.val = val;
    }

    public LinkNode() {
    }
}
class solution{
    //删除链表等于val的元素
    public LinkNode delenum(LinkNode head,int val){
        LinkNode pre = new LinkNode();
        pre.next = head;
        LinkNode temp = pre;
        while (temp.next!=null){
            if(temp.next.val==val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return pre.next;
    }
    //反转链表
    private LinkNode reverseList(LinkNode head){
        LinkNode pre = null;
        LinkNode temp = head;
        while (temp!=null){
            LinkNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return temp;
    }
}
