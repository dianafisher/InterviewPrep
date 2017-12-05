package com.dianafisher.interviewbit.linkedlists;

/**
 * Created by dianafisher on 12/4/17.
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 342 + 465 = 807
 Make sure there are no trailing zeros in the output list
 So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */

public class AddTwoNumbersAsLists {

    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode currA = a;
        ListNode currB = b;

        printList(a);
        printList(b);

        ListNode result = null;
        ListNode current = null;
        int carry = 0;
        while (currA != null && currB != null) {
            int sum = currA.val + currB.val;
            if (carry != 0) {
                sum += carry;
                carry = 0;
            }
            if (sum < 10) {
                if (result == null) {
                    result = new ListNode(sum);
                    current = result;
                } else {
                    current.next = new ListNode(sum);
                    current = current.next;
                }

            } else {

                int num = sum % 10;
                carry = sum / 10;
//                    System.out.println("num = " + num + ", carry = " + carry);
                if (result == null) {
                    result = new ListNode(num);
                    current = result;
                } else {
                    current.next = new ListNode(num);
                    current = current.next;
                }

            }
            currA = currA.next;
            currB = currB.next;
        }

        if (currA == null && currB == null) {
            if (carry != 0) {
                current.next = new ListNode(carry);
            }
        } else {
            while (currA != null) {
                int sum = currA.val;
                if (carry != 0) {
                    sum += carry;
                    carry = 0;
                }
                if (sum < 10) {
                    if (result == null) {
                        result = new ListNode(sum);
                        current = result;
                    } else {
                        current.next = new ListNode(sum);
                        current = current.next;
                    }
                }
                else {

                    int num = sum % 10;
                    carry = sum / 10;
//                    System.out.println("num = " + num + ", carry = " + carry);
                    if (result == null) {
                        result = new ListNode(num);
                        current = result;
                    } else {
                        current.next = new ListNode(num);
                        current = current.next;
                    }

                }
                currA = currA.next;
            }
            while (currB != null) {
                int sum = currB.val;
                if (carry != 0) {
                    sum += carry;
                    carry = 0;
                }
                if (sum < 10) {
                    if (result == null) {
                        result = new ListNode(sum);
                        current = result;
                    } else {
                        current.next = new ListNode(sum);
                        current = current.next;
                    }
                }
                else {

                    int num = sum % 10;
                    carry = sum / 10;
//                    System.out.println("num = " + num + ", carry = " + carry);
                    if (result == null) {
                        result = new ListNode(num);
                        current = result;
                    } else {
                        current.next = new ListNode(num);
                        current = current.next;
                    }

                }
                currB = currB.next;
            }
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }


        return result;
    }


    private static void printList(ListNode list) {
        ListNode cur = list;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.val);
            if (cur.next != null) {
                builder.append(" -> ");
            }
            cur = cur.next;
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        a.next = new ListNode(9);
        a.next.next = new ListNode(9);

        ListNode b = new ListNode(8);
        b.next = new ListNode(8);
        b.next.next = new ListNode(9);

        ListNode s = addTwoNumbers(a, b);
        printList(s);
        System.out.println();

        ListNode c = new ListNode(2);
        c.next = new ListNode(4);
        c.next.next = new ListNode(3);

        ListNode d = new ListNode(5);
        d.next = new ListNode(6);
        d.next.next = new ListNode(4);

        s = addTwoNumbers(c, d);
        printList(s);
        System.out.println();

        ListNode e = new ListNode(9);
        e.next = new ListNode(9);
        e.next.next = new ListNode(1);

        ListNode f = new ListNode(1);
        s = addTwoNumbers(e, f);
        printList(s);

        ListNode g = new ListNode(1);
        ListNode h = new ListNode(9);
        h.next = new ListNode(9);
        h.next.next = new ListNode(9);
        s = addTwoNumbers(g, h);
        printList(s);
    }
}
