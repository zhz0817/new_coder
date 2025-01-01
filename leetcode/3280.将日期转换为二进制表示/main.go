package main

import (
	"strconv"
	"strings"
)

func toBinary(n int32) string {
	var builder strings.Builder
	for n != 0 {
		builder.WriteString(strconv.Itoa(int(n % 2)))
		n /= 2
	}
	return builder.String()
}
func convertDateToBinary(date string) string {
	var builder strings.Builder
	var count int32 = 0
	for i := 0; i <= len(date); i++ {
		if i == len(date) || date[i] == '-' {
			tmp := toBinary(count)
			for j := len(tmp) - 1; j >= 0; j-- {
				builder.WriteRune(rune(tmp[j]))
			}
			if i != len(date) {
				builder.WriteRune('-')
			}
			count = 0
		} else {
			count *= 10
			value := int32(date[i] - '0')
			count += value
		}
	}
	return builder.String()
}

func main() {
	convertDateToBinary("2080-02-29")
}
