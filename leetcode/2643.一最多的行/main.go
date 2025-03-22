func rowAndMaximumOnes(mat [][]int) []int {
	ans := []int{0, 0}
	n := len(mat)
	m := len(mat[0])
	for i := 0; i < n; i++ {
		count := 0
		for j := 0; j < m; j++ {
			if mat[i][j] == 1 {
				count++
			}
		}
		if count > ans[1] {
			ans[0] = i
			ans[1] = count
		}
	}
	return ans
}