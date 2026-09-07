func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	arr1 := make([]int, 26)
	arr2 := make([]int, 26)

	for i := range s {
		arr1[s[i]-'a'] ++
		arr2[t[i]-'a'] ++
	}
	
	for i := range arr1 {
		if arr1[i] != arr2[i] {
			return false
		}
	}
	return true
}
