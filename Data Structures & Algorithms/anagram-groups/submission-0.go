func freq(str string) [26]int {
	var res [26]int 
	for _, c := range str {
		res[c-'a']++
	}
	return res
}

// func groupAnagrams(strs []string) [][]string {
func groupAnagrams(strs []string) [][]string {
	mp := make(map[[26]int][]string)
	for _, str := range strs {
		f := freq(str)
		mp[f] = append(mp[f], str)
	}

	// From map to array 
	res := make([][]string, len(mp))
	i := 0
	for _, v := range mp {
		res[i] = append(res[i], v...)
		i++
	}
	return res
}