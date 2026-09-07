func twoSum(nums []int, target int) []int {
	// Init the hashmap
	kv := make(map[int]int)
	// Lookup
	for i, v := range nums {
		x := target - v 
		j, ok := kv[x]
		if ok {
			return []int{j, i}
		}
		kv[v] = i
	}

	return []int{}
}
