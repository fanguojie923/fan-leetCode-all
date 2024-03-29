//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;// 指针
        int tag = 0;// 进位记录
        while(l1 != null || l2 != null){
            ListNode temp;
            if(l1 == null){
                temp = new ListNode(l2.val+tag);
                l2 = l2.next;
            }else if(l2 == null){
                temp = new ListNode(l1.val+tag);
                l1 = l1.next;
            }else{
                temp = new ListNode(l1.val + l2.val + tag);
                l1 = l1.next;
                l2 = l2.next;
            }
            tag = temp.val / 10;
            temp.val %= 10;
            p.next = temp;
            p = p.next;
        }
        // 检查tag是否为空，不为空则将tag的值设为最高位的值
        p.next = tag > 0 ? new ListNode(tag) : null;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
