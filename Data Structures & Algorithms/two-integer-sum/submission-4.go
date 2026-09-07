func twoSum(nums []int, target int) []int {
	kv := make(map[int]int, len(nums))
	for i, v := range nums {
		x := target - v 
		if j, ok := kv[x]; ok {
			return []int{j, i}
		}
		kv[v] = i
	}

	return []int{}
}
