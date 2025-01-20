class Solution {
    public boolean isValid(String s) {
        var stringArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i =0; i< stringArray.length; i++){
            if(stringArray[i] == '(' || stringArray[i] == '{' || stringArray[i] == '['){
                stack.push(stringArray[i]);
            } else {
                switch(stringArray[i]){
                    case '}':
                        if(stack.size() != 0 && stack.peek() == '{')
                            stack.pop();
                        else
                            return false;    
                        break;

                    case ']':
                        if(stack.size() != 0 && stack.peek() == '[')
                            stack.pop();
                        else
                            return false;    
                        break;

                    case ')':
                        if(stack.size() != 0 && stack.peek() == '(')
                            stack.pop();
                        else
                            return false;    
                        break;

                    default:
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}