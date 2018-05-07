package com.test;

public class LinkedListSorting {

    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        node.next = new ListNode(12);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(11);

        ListNode node1 = new ListNode(10);
        node1.next = new ListNode(12);
        node1.next.next = new ListNode(8);
        node1  = oddEvenList(node1);
//        node = sortLinkedList(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    private static ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMid(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;

        ListNode left = sortLinkedList(head);
        ListNode right = sortLinkedList(nextToMiddle);

        ListNode newHead = sortMerge(left, right);

        return newHead;
    }

    private static ListNode findMid(ListNode head) {
        if(head == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            if(fast!= null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    private static ListNode sortMerge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode result = null;

        if (left.val <= right.val) {
            result = left;
            result.next = sortMerge(left.next, right);
        } else {
            result = right;
            result.next = sortMerge(left, right.next);
        }
        return result;
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode oddNodeHead = null;
        ListNode evenNodeHead = null;
        ListNode evenNodeStart = null;
        ListNode oddNodeStart = null;
        ListNode temp = null;
        ListNode cur = head;
        int count = 1;

        while(cur != null){
            temp = cur;
            cur = cur.next;
            temp.next= null;
            if(count%2 == 0){
                if(evenNodeHead == null){
                    evenNodeHead = temp;
                    evenNodeStart = temp;
                }else{
                    evenNodeHead.next = temp;
                    evenNodeHead = evenNodeHead.next;
                }
            }
            else{
                if(oddNodeHead == null){
                    oddNodeHead = temp;
                    oddNodeStart = temp;
                }else{
                    oddNodeHead.next = temp;
                    oddNodeHead = oddNodeHead.next;
                }
            }

            count++;
        }
        oddNodeHead.next = evenNodeStart;
        return oddNodeStart;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
