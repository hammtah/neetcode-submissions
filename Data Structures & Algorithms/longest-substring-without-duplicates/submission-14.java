class Solution {
    public int lengthOfLongestSubstring(String s) {
        // xzyzayz
        int l = 0, r = 0;
        HashMap<Character, Integer> chars = new HashMap<>();
        int maxLength = 0;
        for (; r < s.length(); r++) {
            int i = chars.getOrDefault(s.charAt(r), -1);
            // Character repeated
            if (i >= 0) {
                chars.replace(s.charAt(r), r);
                if (i >= l) l = i + 1;
            } else {
                // New character
                chars.put(s.charAt(r), r);
            }
            
            int length = r - l + 1 ;
            if (length > maxLength) {
                maxLength = length;
            } 
        } 

        return maxLength;


}
}
