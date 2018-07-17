package link;

/**
 * Created by admin on 2018-07-13.
 */
public class RemoveLink {


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head1;
        head1.next = head2;
        removeElements(head,1);
    }



    /**
     *
     *分清楚节点和链表对象很重要
     * res 对象是res对象，永远为0
     * next指向，在命中的时候，指向下一个，所以先next再赋值next
     * curt遍历向下，prev永远是curt前一个。所以先赋值，再next
     * 链表对象只有一个
     * node对象在跟着程序不断的向下next
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode curt = head;
        ListNode prev = res;

        while(curt != null){
            if(curt.val == val){
                curt = curt.next;
                prev.next = curt;
            }else{
                prev = curt;
                curt = curt.next;
            }
        }
        return res.next;
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
