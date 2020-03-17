package algo.leetcode1108;
//
//Input: address = "1.1.1.1"
//Output: "1[.]1[.]1[.]1"
public class Solution {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("12.321.41.121"));
    }

    public static String defangIPaddr(String address) {

        int start = 0;

        StringBuilder result = new StringBuilder();
        for(int i = 0; i<address.length(); i++)
        {
                if (address.charAt(i) == '.') {
                    result.append(address, start, i).append("[").append(address, i, i + 1).append("]");
                    start = i+1;
                }
        }
        result.append(address,start,address.length());
        return result.toString();
    }
}
