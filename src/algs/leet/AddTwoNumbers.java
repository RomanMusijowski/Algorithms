package algs.leet;

import java.math.BigInteger;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers add = new AddTwoNumbers();

        ListNode listNode = new ListNode(9, null);
        ListNode listNode2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

        ListNode returned  = add.addTwoNumbers(listNode, listNode2);
        System.out.println(returned.toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigInteger first = getInt(l1);
        BigInteger second = getInt(l2);
        BigInteger i = first.add(second);
        String result = String.valueOf(i);
        return returnReverse(result);
    }

    public ListNode returnReverse(String s) {
        ListNode listNode = new ListNode();
        ListNode node = listNode;
        for (int i = s.length()-1; i >= 0  ; i--) {
            Integer integer = Character.getNumericValue(s.charAt(i));
            node.val = integer;
            if (i != 0) {
                node = node.next = new ListNode();
            }
        }
        return listNode;
    }

    public BigInteger getInt(ListNode node) {
        StringBuilder digit = new StringBuilder();
        do {
            digit.insert(0, String.valueOf(node.val));
            node = node.next;
        }while (node != null);
        System.out.println(digit);
        return new BigInteger(String.valueOf(digit));
    }
}
