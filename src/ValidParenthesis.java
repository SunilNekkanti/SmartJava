import java.util.ArrayDeque;
import java.util.Stack;

public class ValidParenthesis {


    public static void main(String[] args) {


        String s = "([])";

        System.out.println(validate(s));


    }

    private static boolean validate(String s) {

        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length();i++){

            char currentChar = s.charAt(i);

            if(currentChar == '(' || currentChar == '{' || currentChar == '['){
                st.push(currentChar);
            }

            else if (currentChar == ')' && !st.empty() && st.peek()=='('){
                st.pop();
            }

            else if (currentChar == '}' && !st.empty() && st.peek()=='{'){
                st.pop();
            }

            else if (currentChar == ']' && !st.empty() && st.peek()=='['){
                st.pop();
            }
            else
                return false;

        }



        return st.empty();

    }
}
