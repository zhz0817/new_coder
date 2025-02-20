func evenOddBit(n int) []int {
	ans := []int{0, 0}
	count := 0
	for n != 0 {
		val := n % 2
		n /= 2
		if val == 1 {
			if count%2 == 0 {
				ans[0]++
			} else {
				ans[1]++
			}
		}
		count++
	}
	return ans
}