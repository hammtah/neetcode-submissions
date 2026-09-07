class Solution {
    public int[] twoSum(int[] nums, int target) {
	HashMap<Integer, Integer> seen = new HashMap<>();
	for (int i = 0; i < nums.length; i++) {
		int missing = target - nums[i]; 
		if (seen.get(missing) != null) {
			return new int[]{seen.get(missing), i};
		} else {
			seen.put(nums[i], i);
		}
	}

	return new int[]{};

    }
}
