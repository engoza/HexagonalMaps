package hexagonalmaps;

/**
 * Author: Mario Gómez Martínez <magomar@gmail.com>
 */
public class Util {
    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }
}
