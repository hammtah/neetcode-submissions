class Solution {
    public static int[] productExceptSelf(int[] nums) {
        List<Integer> prefix = new ArrayList<>(nums.length);
        List<Integer> suffix = new ArrayList<>(nums.length);
        // Prefix array
        if (nums.length == 0) {
            return null;
        }
        prefix.add(1);
        for (int i = 1; i < nums.length; i++) {
            prefix.add(nums[i-1] * prefix.getLast());
        }

        suffix.add(1);
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix.add(nums[i+1] * suffix.getLast());
        }
        
        for (int i = 0; i < nums.length; i++) {
            prefix.set(i, prefix.get(i) * suffix.get(nums.length - 1 - i));
        }

        return prefix.stream().mapToInt(Integer::intValue).toArray();
        // Product of both
    }
}  
