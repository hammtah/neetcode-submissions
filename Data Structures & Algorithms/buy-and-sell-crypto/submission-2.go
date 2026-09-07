func maxProfit(prices []int) int {
	l, r := 0, 1
	price := 0
	for r < len(prices) {
		newPrice := prices[r] - prices[l] 
		if newPrice > price {
			price = newPrice
		}
		if prices[l] <= prices[r] {
			r++
		} else {
			l = r
			r++
		}
	}

	if price <= 0 {
		return 0
	}
	return price
}
