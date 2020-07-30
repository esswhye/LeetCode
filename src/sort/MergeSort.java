package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[]{5, 4, 7, 2, 3, 8};
        int[] hello = test;
        hello = mergeSort(hello);
        Arrays.stream(hello).forEach(System.out::println);
    }

    public static int[] mergeSort(int[] arr) {
        int n = arr.length;

        if (n < 2)
            return arr;

        int mid = n / 2;
        int leftEnd = mid;
        int rightStart = n - mid;

        int[] leftArray = new int[leftEnd];
        int[] rightArray = new int[rightStart];

        for (int i = 0; i < leftEnd; i++) {
            leftArray[i] = arr[i];
        }
        int j = 0;
        for (int i = n - 1; j < rightArray.length; i--) {
            rightArray[j] = arr[i];
            j++;
        }

        //leftArray = Arrays.copyOfRange(arr, 0, rightStart);
        //rightArray = Arrays.copyOfRange(arr, rightStart, n);

        int[] left = mergeSort(leftArray);
        int[] right = mergeSort(rightArray);
        arr = merging(left, right, arr);
        return arr;
    }

    private static int[] merging(int[] leftArray, int[] rightArray, int[] arr) {

        int totalSize = arr.length;

        int[] sorted = new int[totalSize];

        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] > rightArray[j]) {
                sorted[k++] = rightArray[j++];
            } else if (leftArray[i] <= rightArray[j])
                sorted[k++] = leftArray[i++];
        }
        for (; j < rightArray.length; j++) {
            sorted[k++] = rightArray[j];
        }
        for (; i < leftArray.length; i++) {
            sorted[k++] = leftArray[i];
        }

        return sorted;
    }

}
