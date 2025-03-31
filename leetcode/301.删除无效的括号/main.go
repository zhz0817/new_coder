func dfs(leftDelete int, rightDelete int, s string, index int, open int, buffer bytes.Buffer, set1 map[string]int) {
	if index == len(s) {
		if leftDelete == 0 && rightDelete == 0 {
			set1[buffer.String()] = 1
		}
		return
	}
	ch := s[index]
	if ch == '(' && leftDelete > 0 {
		dfs(leftDelete-1, rightDelete, s, index+1, open, buffer, set1)
	}
	if ch == ')' && rightDelete > 0 {
		dfs(leftDelete, rightDelete-1, s, index+1, open, buffer, set1)
	}
	buffer.WriteByte(ch)
	if ch == '(' {
		dfs(leftDelete, rightDelete, s, index+1, open+1, buffer, set1)
	} else if ch == ')' {
		if open > 0 {
			dfs(leftDelete, rightDelete, s, index+1, open-1, buffer, set1)
		}
	} else {
		dfs(leftDelete, rightDelete, s, index+1, open, buffer, set1)
	}
	buffer.Truncate(buffer.Len() - 1)
}
func removeInvalidParentheses(s string) []string {
	leftDelete := 0
	rightDelete := 0
	for i := 0; i < len(s); i++ {
		ch := s[i]
		if ch == '(' {
			leftDelete++
		} else if ch == ')' {
			if leftDelete > 0 {
				leftDelete--
			} else {
				rightDelete++
			}
		}
	}
	set1 := map[string]int{}
	var buffer bytes.Buffer
	dfs(leftDelete, rightDelete, s, 0, 0, buffer, set1)
	ans := make([]string, 0, len(set1))
	for k, _ := range set1 {
		ans = append(ans, k)
	}
	return ans
}