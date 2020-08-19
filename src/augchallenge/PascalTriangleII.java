package augchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 */
public class PascalTriangleII {
    public static void main(String[] args) {
        List<Integer> result = getRow(3);

        result.stream().forEach(System.out::println);
    }

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0)
            return Arrays.asList(0);

        List<Integer> list = new ArrayList<>();
        list.add(1);


        //Looping only list using the before state > new
        for (int i = 1; i <= rowIndex; i++) {

            //if j == 0 break
            for (int j = list.size() - 1; j > 0; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }

            //always add one to the most right 1,2,1<-
            list.add(1);
        }

        return list;
    }
}
