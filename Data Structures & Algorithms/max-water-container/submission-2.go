
func maxArea(heights []int) int {
	
	left := 0
	right := len(heights) - 1
    maxArea := min(heights[left], heights[right]) * (right - left)
	
	for left < right {
		if heights[left] < heights[right] {
			left++
		} else {
			right--
		}
		area := min(heights[left], heights[right]) * (right - left)

		if area > maxArea {
			maxArea = area
		}
	}
	return maxArea
}