func findMin(nums []int) int {
	left := 0
	min := nums[0]
	for left < len(nums) - 1 {
		if nums[left+1] > nums[left] {
			left++
		} else {
			return nums[left+1]
		}
	}
	return min
}
