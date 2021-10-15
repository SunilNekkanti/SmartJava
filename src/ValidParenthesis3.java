public class ValidParenthesis3 {
    public static boolean checkFromLeft(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int starCount = 0;
        int openBraceCount = 0;
        int closedBraceCount = 0;
        for (char currentChar : s.toCharArray()) {
            if (currentChar == '(') {
                openBraceCount++;
            } else if (currentChar == ')') {
                closedBraceCount++;
            } else {
                starCount++;
            }
            if (closedBraceCount > openBraceCount + starCount) {
                return false;
            }
        }
        if (closedBraceCount == openBraceCount || closedBraceCount - openBraceCount <= starCount) {
            return true;
        }
        return false;
    }
    public static boolean checkFromRight(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int starCount = 0;
        int openBraceCount = 0;
        int closedBraceCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (currentChar == ')') {
                openBraceCount++;
            } else if (currentChar == '(') {
                closedBraceCount++;
            } else {
                starCount++;
            }
            if (closedBraceCount > openBraceCount + starCount) {
                return false;
            }
        }
        if (closedBraceCount == openBraceCount || closedBraceCount - openBraceCount <= starCount) {
            return true;
        }
        return false;
    }
    public static boolean checkValidString(String s) {
        return checkFromLeft(s) && checkFromRight(s);
    }

    public static void main(String[] args) {

        System.out.println(checkValidString("(*)"));
    }
}
