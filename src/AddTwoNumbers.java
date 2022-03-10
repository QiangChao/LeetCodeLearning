import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
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
        ListNode node2 = initNode(2,2,3,6,5);
        addTwoNumber(node1, node2);
    }

    public static void  addTwoNumber(ListNode node1, ListNode node2) {
        ListNode node = new ListNode();
        ListNode nodeNext = node;
        int carry = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int one = node1 != null ? node1.val : 0;
            int two = node2 != null ? node2.val : 0;
            int sum = one + two + carry;
            ListNode sumNode = new ListNode();
            sumNode.val = sum % 10;
            carry = sum / 10;
            nodeNext.next = sumNode;
            nodeNext = nodeNext.next;
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }
        print(node.next);
    }

    public static void print(ListNode node) {
        do {
            System.out.println(node.val);
            node = node.next;
        } while ( node != null);
    }

    public static ListNode initNode(Integer ...integers) {
        ListNode oneNone = new ListNode();
        ListNode intialNode = oneNone;
        for (int i = 0; i < integers.length; i++) {
            oneNone.val = integers[i];
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

        int val;

        ListNode next;

     }
}
