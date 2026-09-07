class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray(); 
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            for (;i <= j &&!Character.isLetterOrDigit(str[i]); i++);
            for (;i <= j &&!Character.isLetterOrDigit(str[j]); j--);
            
            if (i <= j && Character.toLowerCase(str[i]) != Character.toLowerCase(str[j])) {
                return false;
            }
        }
        return true;
    }
}
