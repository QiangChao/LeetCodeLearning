import lombok.Data;

import java.util.Arrays;

/**
 *  link: https://leetcode.com/problems/add-two-numbers/
 *       you are given two non-empty representing two non-negative integers, The digits are stored in reverse order, and each of their nodes
 *  contains a single digit, add the two numbers and return the sum as a linked list.
 *       you may assume the two numbers not contain leading zero, expect zero itself
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = initNode(1,2,3,6,4);
        ListNode node2 = initNode(2,2,3,6,4);
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        String digital1 = toStringBuffer(node1, buffer1);
        String digital2 = toStringBuffer(node2, buffer2);
        Long result = Long.parseLong(digital1) + Long.parseLong(digital2);
        String resultStr = new StringBuffer(String.valueOf(result)).reverse().toString();
        ListNode resultNode = initNode(Arrays.stream(resultStr.split("")).map(Integer::valueOf).toArray(Integer[]::new));
        print(resultNode);
    }

    public static void print(ListNode node) {
        do {
            System.out.println(node.value);
            node = node.next;
        } while ( node != null);
    }

    public static String toStringBuffer(ListNode node, StringBuffer buffer) {
        do {
            buffer.append(node.value);
            node = node.next;
        } while ( node != null);
        return buffer.reverse().toString();
    }

    public static ListNode initNode(Integer ...integers) {
        ListNode oneNone = new ListNode();
        ListNode intialNode = oneNone;
        for (int i = 0; i < integers.length; i++) {
            oneNone.value = integers[i];
            if (i == integers.length -1) {
                continue;
            }
            ListNode nextNode = new ListNode();
            oneNone.next = nextNode;
            oneNone = nextNode;
        }
        return intialNode;
    }

    /**
      Definition for singly-linked list.
     */
    @Data
    static class ListNode {

        int value;

        ListNode next;

     }
}
