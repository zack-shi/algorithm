package com.zack.algorithm.linkedlist;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * 142. 环形链表 II
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 */
public class LinkedListCycleII {

    /**
     * 快慢指针，慢指针走一步，快指针走两部，两个指针一定在环中相遇
     * 假设从头结点到环形入口节点 的节点数为x。 环形入口节点到 fast指针与slow指针相遇节点 节点数为y。 从相遇节点 再到环形入口节点节点数为 z
     * 相遇时： slow指针走过的节点数为: x + y， fast指针走过的节点数：x + y + n (y + z)，n为fast指针在环内走了n圈
     * 通过整理计算后得 x = (n - 1) (y + z) + z
     * 结论，两个节点，一个从相遇节点出发，一个从起始出发，每次走一步，一定能在环的入口相遇
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        //找到环中相遇节点
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;//无环
        }
        fast=head;
        while (slow!=fast){ //一个从起始出发，每次走一步，一定能在环的入口相遇
           fast=fast.next;
           slow=slow.next;
        }
        return fast; //返回入口节点
    }


}
