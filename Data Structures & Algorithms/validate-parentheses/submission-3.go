type Stack []rune
func (s *Stack) Push(val rune) {
	*s = append(*s, val)
}
func (s *Stack) Pop() {
	*s = (*s)[:len(*s)-1]
}
func (s *Stack) Peek() (rune, bool) {
	if len(*s) == 0 {
		return 0, false
	} 
	return (*s)[len(*s)-1], true
}
func (s *Stack) Empty() bool {
	return len(*s) == 0
}

func isOpening(c rune) bool {
	if c == '(' || c == '[' || c == '{' {
		return true
	}
	return false
}

func pair(o, c rune) bool {
	switch o {
		case '(':
			if c == ')' {
				return true
			}
			return false
		case '{':
			if c == '}' {
				return true
			}
			return false

		case '[':
			if c == ']' {
				return true
			}
			return false
	}
	return false
}

func isValid(s string) bool {
	if len(s) == 0 {
		return true
	}
	stack := make(Stack, 0)
    for _, c := range s {
		if isOpening(c) {
			stack.Push(c)
		} else {
			v, ok := stack.Peek()
			if !ok {
				return false
			}
			if !pair(v, c) {
				return false
			} 
			stack.Pop()
		}
	}

	if stack.Empty() {
		return true
	}
	return false
}
