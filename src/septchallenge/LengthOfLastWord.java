package septchallenge;

public class LengthOfLastWord {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWordV2(" a"));
    }

    public static int lengthOfLastWord(String s) {
        /*
        if (s.length() == 0 || Character.isWhitespace(s.charAt(0)) && s.length() < 2) {
            return 0;
        }*/

        String[] strSplit = s.split(" ");

        if (strSplit.length == 0) {
            return 0;
        }

        return strSplit[strSplit.length - 1].length();
    }

    public static int lengthOfLastWordV2(String s) {
        /*
        if (s.length() == 0 || Character.isWhitespace(s.charAt(0)) && s.length() < 2) {
            return 0;
        }*/

        //Find the first alphabet starting from the back
        int i = s.length() - 1;
        while (i >= 0) {

            if (Character.isLetter(s.charAt(i))) {
                break;
            }
            i--;
        }

        int counter = 0;
        /*
        while (i >= 0) {
            if (Character.isLetter(s.charAt(i))) {
                counter++;

            } else if (s.charAt(i) == ' ') {
                break;
            }
            i--;
        }*/

        while (i >= 0 && s.charAt(i) != ' ') {
            counter++;
            i--;
        }


        return counter;
    }
}
