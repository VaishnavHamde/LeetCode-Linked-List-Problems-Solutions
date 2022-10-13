// https://leetcode.com/problems/add-two-numbers/

/*
	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, 
	and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example 1:
	
	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [7,0,8]
	Explanation: 342 + 465 = 807.
	Example 2:
	
	Input: l1 = [0], l2 = [0]
	Output: [0]
	Example 3:
	
	Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	Output: [8,9,9,9,0,0,0,1]
	 
	Constraints:
	
	The number of nodes in each linked list is in the range [1, 100].
	0 <= Node.val <= 9
	It is guaranteed that the list represents a number that does not have leading zeros.
*/
package com.medium.problems;

class ListNode {
	int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode l3 = new ListNode();
     ListNode head = l3;
     int num = 0;
     int h = 0;
     
     while(l1 != null || l2 != null){
         if(l1 != null && l2 != null)
             num = l1.val + l2.val + h;
         else if(l1 == null)
             num = l2.val + h;
         else if(l2 == null)
             num = l1.val + h;
         
         if(l1 != null)
             l1 = l1.next;
         if(l2 != null)
             l2 = l2.next;
         
         if(num > 9){
             l3.val = num%10;
             h = 1;
         }
         else{
             l3.val = num;
             h = 0;
         }
         
         if(l1 != null || l2 != null){
             l3.next = new ListNode();
             l3 = l3.next;
         }
     }
     if(h == 1){
         l3.next = new ListNode(1);
     }
     return head;
 }
}

