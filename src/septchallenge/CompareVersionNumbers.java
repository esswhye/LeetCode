package septchallenge;

/**
 * 165. Compare Version Numbers
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * <p>
 * The . character does not represent a decimal point and is used to separate number sequences.
 * <p>
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * You may assume the default revision number for each level of a version number to be 0.
 * For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 * <p>
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 * <p>
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * Example 4:
 * <p>
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * Example 5:
 * <p>
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {


        System.out.println(compareVersionV3("0.1", "1.1"));
        System.out.println(compareVersionV3("1.0.1", "1"));
        System.out.println(compareVersionV3("7.5.2.4", "7.5.3"));
        System.out.println(compareVersionV3("1.01", "1.001"));
        System.out.println(compareVersionV3("1.0", "1.0.0"));


    }

    public static int compareVersion(String version1, String version2) {
        /**
         * In regular expression, the "." is a metacharacter with special meaning which matches any single character except a newline.
         * You got an array with zero element because "." matches any character in your string.
         *
         * A preceding backslash ("\") turns a character into a literal character.
         * Because this is also the Java escape character in strings, you need to use "\\" to present the backslash character.
         * To split a string with a literal '.' character in Java, you must use split("\\.").
         */
        String[] strSplit1 = version1.split("\\.");
        String[] strSplit2 = version2.split("\\.");

        int maxL = Math.max(strSplit1.length, strSplit2.length);
        int pow = 1;
        double ver1 = 0, ver2 = 0;

        for (int i = 0; i < maxL; i++) {
            if (strSplit1[i] != null && strSplit2[i] != null) {
                if (Integer.parseInt(strSplit1[i]) > Integer.parseInt(strSplit2[i]))
                    ver1 = ver1 + (1 * (Math.pow(10, maxL - pow)));
                else if (Integer.parseInt(strSplit1[i]) < Integer.parseInt(strSplit2[i])) {
                    ver2 = ver2 + (1 * (Math.pow(10, maxL - pow)));
                }
            } else if (strSplit1[i] != null && strSplit2[i] == null) {
                ver1 = ver1 + (1 * (Math.pow(10, maxL - pow)));
            } else if (strSplit1[i] == null && strSplit2[i] != null) {
                ver2 = ver2 + (1 * (Math.pow(10, maxL - pow)));
            }
            pow++;

        }

        System.out.println(ver1 + " " + ver2);

        if (ver1 > ver2) {
            return 1;
        } else if (ver2 > ver1) {
            return -1;
        } else {
            return 0;
        }

    }

    public static int compareVersionV2(String version1, String version2) {


        long countVer1 = version1.chars().filter(ch -> ch == '.').count();
        long countVer2 = version2.chars().filter(ch -> ch == '.').count();

        if (countVer1 > countVer2) {
            for (int i = 0; i < countVer1 - countVer2; i++)
                version2 += ".0";
        } else if (countVer2 > countVer1) {
            for (int i = 0; i < countVer2 - countVer1; i++) {
                version1 += ".0";
            }
        }


        String[] strSplit1 = version1.split("\\.");
        String[] strSplit2 = version2.split("\\.");


        int maxL = Math.max(strSplit1.length, strSplit2.length);
        int pow = 1;
        double ver1 = 0, ver2 = 0;

        for (int i = 0; i < maxL; i++) {

            if (Integer.parseInt(strSplit1[i]) > Integer.parseInt(strSplit2[i]))
                ver1 = ver1 + (1 * (Math.pow(10, maxL - pow)));
            else if (Integer.parseInt(strSplit1[i]) < Integer.parseInt(strSplit2[i])) {
                ver2 = ver2 + (1 * (Math.pow(10, maxL - pow)));
            }

            pow++;

        }


        if (ver1 > ver2) {
            return 1;
        } else if (ver2 > ver1) {
            return -1;
        } else {
            return 0;
        }

    }

    public static int compareVersionV3(String version1, String version2) {
        String[] strSplit1 = version1.split("\\.");
        String[] strSplit2 = version2.split("\\.");

        int i = 0;
        int maxL = Math.max(strSplit1.length, strSplit2.length);


        while (i < maxL) {

            if (i < strSplit1.length && i < strSplit2.length) {
                if (Integer.parseInt(strSplit1[i]) > Integer.parseInt(strSplit2[i])) {
                    return 1;
                } else if (Integer.parseInt(strSplit2[i]) > Integer.parseInt(strSplit1[i]))
                    return -1;
            } else if (i < strSplit1.length) {
                if (Integer.parseInt(strSplit1[i]) != 0)
                    return 1;
            } else if (i < strSplit2.length)
                if (Integer.parseInt(strSplit2[i]) != 0)
                    return -1;
            i++;
        }

        return 0;

    }

}
