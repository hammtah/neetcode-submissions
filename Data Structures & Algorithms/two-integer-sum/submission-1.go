func twoSum(nums []int, target int) []int {
	// Init the hashmap
	kv := make(map[int]int)
	for i, v := range nums {
		kv[v] = i
	}

	// Lookup
	for i, v := range nums {
		x := target - v 
		j, ok := kv[x]
		if ok && i != j {
			return []int{i, j}
		}
	}

	return []int{}
}