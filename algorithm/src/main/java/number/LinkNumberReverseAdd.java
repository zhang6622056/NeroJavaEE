package number;

//链表求和
//你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
// 样例
//给出两个链表 3->1->5->null 和 5->9->2->null，返回 8->0->8->null
public class LinkNumberReverseAdd {



    public static void main(String[] args) {

    }



    //与二进制相同，既然是相反的顺序，那么就相反的顺序进行加法和进位保存。
    //然后进位与相加的数进行加法
    public ListNode addLists(ListNode l1, ListNode l2) {


        int firstsum = l1.val+l2.val;
        ListNode current = new ListNode(firstsum % 10);
        ListNode res = current;


        int cursum = firstsum / 10;
        while(null != l1.next || null != l2.next){
            cursum += l1.next == null ? 0 : l1.next.val;
            cursum += l2.next == null ? 0 : l2.next.val;

            current.next = new ListNode(cursum % 10);
            current = current.next;
            cursum = cursum / 10;

            l1 = l1.next == null ? l1 : l1.next;
            l2 = l2.next == null ? l2 : l2.next;
        }

        if(cursum > 0){
            current.next = new ListNode(cursum);
        }
        return res;

    }




    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
