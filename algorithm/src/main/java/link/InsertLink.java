package link;

// 在排序链表中插入一个节点
//        在链表中插入一个节点。
//
//        样例
//        给出一个链表 1->4->6->8 和 val = 5.。
//
//        插入后的结果为 1->4->5->6->8。
public class InsertLink {



    /**
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        ListNode res = null;
        if(null == head){
            return new ListNode(val);
        }

        //第一个
        if(val < head.val){
            res = new ListNode(val);
            res.next = head;
            return res;
        }


        res = head;
        while(null != head.next){
            if(head.val == val){
                changePosition(head,val);
                return res;
            }


            if(head.val < val && val < head.next.val){
                changePosition(head,val);
                return res;
            }
            head = head.next;
        }


        if(val > head.val){
            head.next = new ListNode(val);
        }
        return res;
    }


    /****
     * 插入操作
     * @param head
     * @param val
     */
    public static void changePosition(ListNode head,int val){
        ListNode t = new ListNode(val);
        t.next = head.next;
        head.next = t;
    }




    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
