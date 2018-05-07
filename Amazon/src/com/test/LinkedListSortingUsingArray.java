package com.test;

import java.util.HashMap;
import java.util.Map;

public class LinkedListSortingUsingArray {
    public static void main(String[] args){
        int[] arr = {12,8,10,6};
        ListNode node = new ListNode(10);
        node.next = new ListNode(12);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next = new ListNode(12);
        node.next.next.next.next.next.next = new ListNode(10);

        node = sortList(node, arr);
    }

    private static ListNode sortList(ListNode node, int[] arr){
        if(node == null || arr == null || arr.length == 0){
            return null;
        }

        Map<Integer, Integer> integerCountMap = new HashMap<>();
        ListNode current = node;
        while(current != null){
            if(integerCountMap.get(current.val) != null){
                integerCountMap.put(current.val, integerCountMap.get(current.val) + 1);
            }else{
                integerCountMap.put(current.val, 1);
            }
            current = current.next;
        }
        current = node;
        int arrLength = arr.length; int i = 0;
        while(i < arrLength && current != null){
            if(integerCountMap.get(arr[i]) == null){
                return null;
            }
            int count = integerCountMap.get(arr[i]);

            while(current != null && count > 0){
                current.val = arr[i];
                current = current.next;
                count--;
            }
            i++;
        }
        if(i < arrLength)return null;
        return node;

    }
}
