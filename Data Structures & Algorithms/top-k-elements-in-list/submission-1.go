func topKFrequent(nums []int, k int) []int {
    // Make a frequency map
    mp := make(map[int]int)
    for _, n := range nums {
        mp[n]++
    }

    // Make a frequency:indexes map
    mp2 := make(map[int][]int)
    for index, freq := range mp {
        mp2[freq] = append(mp2[freq], index)
    }

    res := make([]int, 0)
    for i := len(nums); i >= 0; i-- {
        if len(res) >= k {
            return res[:k]
        }
        if indexes, ok := mp2[i]; ok {
            res = append(res, indexes...)
        }
    }

    return res[:k]
}
