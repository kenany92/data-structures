package com.kenany.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * This is one use case of stack data structure. Read the problem.txt file inside the test package to understand what is it
 * com.kenany.stack.StackUseCase
 * @author kenany (armelknyobe@gmail.com)
 */
public class StackUseCase {

    /**
     * Please read the problem.txt inside the test package
     * @param input
     * @return
     */
    public boolean checkBalanced(String input) {

        int size = input.length();
        String closer = "]})";
        Map<String, String> map = new HashMap<>();
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < size; i++) {

            String ch = String.valueOf(input.charAt(i));

            /**
             * Once closing bracket is found, the opening that match should already exists in the stack
             * and should be at the top of the stack.
             * {[(})( : should be false because there isn't opening curly at the index 3 that match to the
             * close at the position 4; don't need to continue!
             */
            if (closer.contains(ch)) {

                // Stack can't start with a closing bracket
                if (stack.isEmpty()) {
                    return false;
                // The closing bracket should match to the opening bracket at the top of the stack
                } else if (!map.get(ch).equals(stack.peek())) {
                    return false;
                } else {
                    // Remove the latest added bracket if it match
                    stack.pop();
                }
            } else {
                // Only add the opening bracket
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
