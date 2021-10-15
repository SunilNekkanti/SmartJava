class BackSpaceSolution {
    public static boolean backspaceCompare(String string1, String string2) {
        int string1EndPosition = string1.length() - 1, string2EndPosition = string2.length() - 1;
        int string1SkipCount = 0, string2SkipCount = 0;

        while (string1EndPosition >= 0 || string2EndPosition >= 0) {
            while (string1EndPosition >= 0) {
                if (string1.charAt(string1EndPosition) == '#') {string1SkipCount++; string1EndPosition--;}
                else if (string1SkipCount > 0) {string1SkipCount--; string1EndPosition--;}
                else break;
            }
            while (string2EndPosition >= 0) {
                if (string2.charAt(string2EndPosition) == '#') {string2SkipCount++; string2EndPosition--;}
                else if (string2SkipCount > 0) {string2SkipCount--; string2EndPosition--;}
                else break;
            }

            if (string1EndPosition >= 0 && string2EndPosition >= 0 && string1.charAt(string1EndPosition) != string2.charAt(string2EndPosition))
                return false;

            if ((string1EndPosition >= 0) != (string2EndPosition >= 0))
                return false;
            string1EndPosition--; string2EndPosition--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#", "ac#"));
    }
}