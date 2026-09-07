
/*
We are looking for x1+x2+x3 = 0 with no duplicates.
- To find x2 and x3 we can simply do the 2 sum using a map or l & r ptrs.
- To solve duplicates problem we sort the array and we skip duplicates, this way 
we don't encounter the same triplet.
*/
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	res := make([][]int, 0)
	for i := 0; i < len(nums); i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		res = append(res, twoSum3(nums[i+1:], -nums[i])...)
	}
	return res
}

// Return all two sum combinations
// numbers[] should be sorted
func twoSum3(numbers []int, target int) [][]int {
	l, r := 0, len(numbers) - 1
	res := make([][]int, 0)
	for l < r {
		// Ignore duplicates
		if (l > 0 && numbers[l] == numbers[l-1]) {
			l++
			continue
		} 
		if (r < (len(numbers) - 1) && numbers[r+1] == numbers[r]) {
			r--
			continue
		}
		sum := numbers[l] + numbers[r]
		if sum < target {
			l++
		} else if sum > target {
			r--
		} else {
			// appending -target to result is opposit to SRP but its the easiest way to append the 
			// 3rd elm of the sum in a two dimension array
			res = append(res, []int{-target, numbers[l], numbers[r]})
			l++
			r--
		}
	}
	return res
}