package FirstExersize;

import java.util.Stack;

public class findBracePairs extends findPairs{

    public findBracePairs(String input) {
        super(input);
    }

    @Override
    public int getPairs() {

        Stack<Integer>stack = new Stack<>();

        stack.push(0);
        boolean isInside = false;
        for(int i=1;i<input.length();i++) {
            char ch = input.charAt(i);

            if(ch=='"'){
                if(input.charAt(i-1)=='\\'){
                    isInside = !isInside;
                }
            }
            if(!isInside){
                if(ch=='{'){
                    stack.push(i);
                }
                if(ch=='}'){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    return i;
                }
            }
        }
        return -1;
    }
}
