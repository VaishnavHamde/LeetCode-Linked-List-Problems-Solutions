// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

Follow up: Could you do this in one pass?
*/

package com.medium.problems;

class ListNode1 {
	int val;
	ListNode1 next;
	ListNode1() {}
	ListNode1(int val) { this.val = val; }
	ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}

public class Remove_Nth_Node_From_End_of_List {
	public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        ListNode1 temp = head;
        int count = 0;
        
        while(temp != null){
            temp = temp.next;
            count++;
        }
        
        if(count == 1)
            return null;
        
        if(count == n)
            return head.next;
        
        int pos = count - n - 1;
        temp = head;
        
        for(int i = 0; i < pos; i++)
            temp = temp.next;

        temp.next = temp.next.next;
        
        return head;
    }
}
