package main

func reverseString(s string) string {
	// 将字符串转换为 rune 切片
	runes := []rune(s)
	// 获取 rune 切片的长度
	n := len(runes)
	// 反转 rune 切片
	for i := 0; i < n/2; i++ {
		runes[i], runes[n-1-i] = runes[n-1-i], runes[i]
	}
	// 将 rune 切片转换回字符串
	return string(runes)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func longestCycle(edges []int) int {
	ans := -1
	n := len(edges)
	inDegree := make([]int, n)
	for _, next := range edges {
		if next != -1 {
			inDegree[next]++
		}
	}
	queue := make([]int, 0)
	for i, val := range inDegree {
		if val == 0 {
			queue = append(queue, i)
		}
	}
	isVisited := make([]bool, n)
	for len(queue) > 0 {
		next := edges[queue[0]]
		queue = queue[1:]
		if next == -1 {
			continue
		}
		inDegree[next]--
		if inDegree[next] == 0 {
			queue = append(queue, next)
		}
	}
	for i := 0; i < n; i++ {
		if !isVisited[i] && inDegree[i] > 0 {
			tmp := 0
			index := i
			for !isVisited[index] {
				tmp++
				isVisited[index] = true
				index = edges[index]
			}
			ans = max(ans, tmp)
		}
	}
	return ans
}
func main() {

}
