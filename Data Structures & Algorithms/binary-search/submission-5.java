class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int l = start + (end - start) / 2;
        if (nums[l] == target) {
            return l;
        }
        if (nums[l] < target) {
            return search(nums, l+1, end, target);
        } else {
            return search(nums, start, l-1, target);
        }
        

    }
}
