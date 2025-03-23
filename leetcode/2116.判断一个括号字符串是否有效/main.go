func canBeValid(s string, locked string) bool {
	n := len(s)
	if n%2 == 1 {
		return false
	}
	count1 := 0
	count2 := 0
	count3 := 0
	for i := 0; i < n; i++ {
		ch := s[i]
		if ch == '(' {
			if locked[i] == '0' {
				count3++
			} else {
				count1++
			}
		} else {
			if locked[i] == '0' {
				count3++
			} else {
				count2++
			}
		}
		if count1+count3 < count2 {
			return false
		}
	}
	count1 = 0
	count2 = 0
	count3 = 0
	for i := 0; i < n; i++ {
		ch := s[n-i-1]
		if ch == '(' {
			if locked[n-i-1] == '0' {
				count3++
			} else {
				count1++
			}
		} else {
			if locked[n-i-1] == '0' {
				count3++
			} else {
				count2++
			}
		}
		if count2+count3 < count1 {
			return false
		}
	}
	return true
}