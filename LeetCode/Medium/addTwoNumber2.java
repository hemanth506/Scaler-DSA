import Medium.ListNode;


public class addTwoNumber2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;

        ListNode result = null;
        ListNode resStart = null;
        int val1 = 0;
        int val2 = 0;
        int totV = 0;
        int modV = 0;
        int divV = 0;
        while (tempL1 != null && tempL2 != null) {
            val1 = tempL1.val;
            val2 = tempL2.val;

            totV = val1 + val2 + divV;
            modV = totV % 10;
            ListNode newNode = new ListNode(modV);
            // System.out.println(newNode.val);

            if(result == null) {
                result = newNode;
                resStart = newNode;
            } else {
                result.next = newNode;
                result = result.next;
            }
            divV = totV / 10;
            tempL1 = tempL1.next;
            tempL2 = tempL2.next;
        }
        if(tempL1 != null) {
            while (tempL1 != null) {
                val1 = tempL1.val;
                totV = val1 + divV;
                modV = totV % 10;
                ListNode newNode = new ListNode(modV);
                // System.out.println(newNode.val);
                
                result.next = newNode;
                result = result.next;

                divV = totV / 10;
                tempL1 = tempL1.next;
            }
        } else if (tempL2 != null) {
            while (tempL2 != null) {
                val2 = tempL2.val;
                totV = val2 + divV;
                modV = totV % 10;
                ListNode newNode = new ListNode(modV);
                // System.out.println(newNode.val);

                result.next = newNode;
                result = result.next;

                divV = totV / 10;
                tempL2 = tempL2.next;
            }
        }

        if(divV != 0) {
            ListNode newNode = new ListNode(divV);
            result.next = newNode;
        }

        return resStart;
    }
    public static void main(String[] args) {
        
    }
}
