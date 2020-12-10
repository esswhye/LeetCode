package dec2020;

//941. Valid Mountain Array
public class ValidMountainArray {

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0, 1, 2, 4, 2, 1}));
    }

    public static boolean validMountainArray(int[] arr) {
        boolean isPeak = false;
        boolean up = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (!isPeak) {
                if (arr[i] > arr[i + 1]) {
                    isPeak = true;
                } else if (arr[i] == arr[i + 1]) {
                    return false;
                } else {
                    up = true;
                }
            } else {
                if (arr[i] <= arr[i + 1]) {
                    return false;
                }
            }


        }

        return isPeak && up;

//        int i=0;
//        while(i+1<arr.length && arr[i]<arr[i+1])
//            i++;
//        if(i==0 || i==arr.length-1)
//            return false;
//        while(i+1<arr.length && arr[i]>arr[i+1])
//            i++;
//        return i==arr.length-1;
    }
}
