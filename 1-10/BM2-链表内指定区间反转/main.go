package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func ReverseList(pre *ListNode, cur *ListNode, count int) *ListNode {
	// write code here
	head := pre
	for cur != nil && count > 0 {
		tmp := cur.Next
		cur.Next = pre
		pre = cur
		cur = tmp
		count--
	}
	head.Next = cur
	return pre
}

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	// write code here
	var pre *ListNode = &ListNode{1, nil}
	cur := head
	pre.Next = cur
	ans := pre
	for i := 1; i < m; i++ {
		pre = cur
		cur = cur.Next
	}
	pre.Next = ReverseList(pre.Next, cur.Next, n-m)
	return ans.Next
}
func main() {

}
