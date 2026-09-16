class Solution {
    // Find the cut of the two sorted subarrays.
    // Find Which subarray the target belongs to.
    // Search the target within it.
    public static int search(int[] nums, int target) {
        int i = findMin(nums);
        int targetIndex = -1;
        if (i > 0 && target >= nums[0]) {
            targetIndex = binarySearch(nums, 0, i - 1, target);
        } else {
            targetIndex = binarySearch(nums, i, nums.length - 1, target);
        }
        return targetIndex;
    }

    // Ordinary BS Algo
    public static int binarySearch(int[] nums, int start, int end, int target) {
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

    // Find the min (the cut between the two sorted arrays) using Binary Search
    public static int findMin(int[] nums) {
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
