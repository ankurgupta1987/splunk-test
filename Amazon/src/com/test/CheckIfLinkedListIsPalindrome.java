package com.test;

public class CheckIfLinkedListIsPalindrome {
    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        node.next = new ListNode(12);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next = new ListNode(12);
        node.next.next.next.next.next.next = new ListNode(10);


        boolean is = isLinkedListAPalindrome(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    private static boolean isLinkedListAPalindrome(ListNode head){

        if(head == null || head.next == null)return true;
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        ListNode temp = null;
        ListNode current = slowPtr.next;
        while(current != null){
            slowPtr = current;
            current = current.next;
            slowPtr.next = temp;
            temp = slowPtr;
        }

        while(temp !=null && head != null){
            if(temp.val != head.val){
                return false;
            }
            temp = temp.next;
            head = head.next;
        }


        return true;
    }
}
