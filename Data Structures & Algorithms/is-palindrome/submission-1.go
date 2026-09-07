func isAlphanumeric(c byte) bool {
	return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')
}

func isPalindrome(s string) bool {
	i, j := 0, len(s) - 1
	for {
		if j <= i {
			break
		}
		for i < len(s) - 1 && !isAlphanumeric(s[i]){
			i++
		}
		for j >= 0 && !isAlphanumeric(s[j]) {
			j--
		}
		if j <= i {
			break
		}
		if unicode.ToLower(rune(s[i])) != unicode.ToLower(rune(s[j])) {
			return false
		}
		i++
		j--
	}
	return true
}