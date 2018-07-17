package link;

/**
 * Created by admin on 2018-07-13.
 */
public class MidLink {


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        middleNode(a);
    }



    /*
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public static ListNode middleNode(ListNode head) {
        ListNode a = head;
        int cou = 0;
        while(null != head){
            cou++;
            head = head.next;
        }


        ListNode res = null;
        int con = 0;
        if(cou % 2 == 0){
           con = cou /2;
        }else{
            con = cou/2+1;
        }


        for(int i= 0 ; i < con ;i++){
            res = a;
            a = a.next;
        }

        return res;
    }







    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
