func addSpaces(s string, spaces []int) string {
	sb := strings.Builder{}
	n := len(s)
	index := 0
	for i := 0; i < n; i++ {
		ch := s[i]
		if index < len(spaces) && i == spaces[index] {
			sb.WriteRune(' ')
			index++
		}
		sb.WriteRune(rune(ch))
	}
	return sb.String()
}