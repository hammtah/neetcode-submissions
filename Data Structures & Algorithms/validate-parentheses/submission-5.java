class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpen(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char c = stack.peek();
                if (!isComplement(c, s.charAt(i))) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;

    }

    public boolean isOpen(char c) {
        return (c == '{' || c == '[' || c == '(');
    }

    public boolean isComplement(char open, char close) {
        return ((open == '{' && close == '}') || (open == '[' && close == ']') || (open == '(' && close == ')'));
    }
}
