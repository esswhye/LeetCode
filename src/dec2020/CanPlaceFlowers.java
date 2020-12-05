package dec2020;

//605
public class CanPlaceFlowers {
    public static void main(String[] args) {
        canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 1);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) {
            return true;
        }

        int count = 0;

        if (flowerbed.length == 1) {

            if (flowerbed[0] == 0) {
                return n == 1;
            }


        }

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            count++;
        }

        for (int i = 1; i < flowerbed.length - 1; i++) {

            if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1 && flowerbed[i] != 1) {
                flowerbed[i] = 1;
                count++;
            }
        }

        if (flowerbed.length >= 2 && flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            count++;
        }

        return count >= n;


    }
}
