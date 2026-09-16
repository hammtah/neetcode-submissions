class Solution {

    public static int search(int[] nums, int target) {
        int i = bmin(nums);
        int targetIx = -1;
        if (i > 0 && target >= nums[0]) {
            targetIx = bs(nums, 0, i - 1, target);
        } else {
            targetIx = bs(nums, i, nums.length - 1, target);
        }
        return targetIx;
    }
    public static int bs(int[] nums, int start, int end, int target) {
        int l = start, r = end;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public static int bmin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
