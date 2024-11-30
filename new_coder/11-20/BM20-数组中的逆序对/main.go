package main

import (
	"sort"
)

type node struct {
	Val   int
	Index int
}

const maxLength int = 100010
const mod int = 10_0000_0007

var n int
var trees [maxLength]int
var ranks [maxLength]int

type ByValue []node

func (a ByValue) Len() int { return len(a) }

func (a ByValue) Less(i, j int) bool {
	if a[i].Val != a[j].Val {
		return a[i].Val < a[j].Val
	}
	return a[i].Index < a[j].Index
}

func (a ByValue) Swap(i, j int) { a[i], a[j] = a[j], a[i] }

func lowBit(n int) int {
	return n & (-n)
}
func add(x int, k int) {
	for i := x; i <= n; i += lowBit(i) {
		trees[i] += k
	}
}

func query(x int) int {
	sum := 0
	for i := x; i > 0; i -= lowBit(i) {
		sum += trees[i]
	}
	return sum
}
func InversePairs(nums []int) int { //树状数组
	// write code here
	n = len(nums)
	var nodes []node
	nodes = append(nodes, node{Val: -1 * mod, Index: -1})
	for i := 0; i < n; i++ {
		tmp := node{Val: nums[i], Index: i + 1}
		nodes = append(nodes, tmp)
	}
	sort.Sort(ByValue(nodes))
	for i := 1; i <= n; i++ {
		ranks[nodes[i].Index] = i
	}
	ans := 0
	for i := 1; i <= n; i++ {
		add(ranks[i], 1)
		ans += i - query(ranks[i])
		ans %= mod
	}
	return ans
}
func main() {
	nums := []int{1, 2, 3, 4, 5, 6, 7, 0}
	InversePairs(nums)
}
