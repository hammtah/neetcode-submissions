class Solution {
    public int search(int[] nums, int target) {
        for (int l = 0, r = nums.length - 1; l <= r; l++, r--) {
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
        }
        return -1;
    }
}
