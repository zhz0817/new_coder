package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func Merge(pHead1 *ListNode, pHead2 *ListNode) *ListNode {
	// write code here
	var ans *ListNode = &ListNode{1, nil}
	node := ans
	for pHead1 != nil && pHead2 != nil {
		value1 := pHead1.Val
		value2 := pHead2.Val
		if value1 < value2 {
			node.Next = pHead1
			pHead1 = pHead1.Next
		} else {
			node.Next = pHead2
			pHead2 = pHead2.Next
		}
		node = node.Next
	}
	if pHead1 != nil {
		node.Next = pHead1
	}
	if pHead2 != nil {
		node.Next = pHead2
	}
	return ans.Next
}
func main() {

}
