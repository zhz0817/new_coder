func percentageLetter(s string, letter byte) int {
	count := 0
	for _, ch := range s {
		if ch == int32(letter) {
			count++
		}
	}
	return 100 * count / len(s)
}