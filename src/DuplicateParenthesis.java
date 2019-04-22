import java.util.Stack;

// Java program to find duplicate parenthesis in a
// balanced expression
public class DuplicateParenthesis {

    // Function to find duplicate parenthesis in a
// balanced expression
// Function to check redundant brackets in a
// balanced expression

    static boolean checkRedundancy(String s) {
        // create a stack of characters
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {

            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.peek();
                st.pop();

                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;

                while (top != '(') {

                    // Check for operators in expression
                    if (isOperator(top)) {
                        flag = false;
                    }

                    // Fetch top element of stack
                    top = st.peek();
                    st.pop();
                }

                // If operators not found
                if (flag) {
                    return true;
                }
            } else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return false;
    }







    // Driver code
    public static void main(String[] args) {

        // input balanced expression
        String str = "(((a+(b)))+(c+d))";//"(((a+(b)+(c+d)))";

        System.out.println(checkRedundancy(str));


    }


    static boolean isOperator(char o) {

        if (o == '%' || o == '/' || o == '*' || o == '+' || o == '-') {
            return true;
        } else {
            return false;
        }
    }

}



