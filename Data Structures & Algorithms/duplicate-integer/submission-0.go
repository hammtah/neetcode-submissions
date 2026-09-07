func hasDuplicate(nums []int) bool {
	mp := make(map[int]int)
	for _, n := range nums {
		mp[n] += 1
		if mp[n] > 1 {
			return true
		}
	}
	return false
}
