package satellite;

import java.util.Scanner;
import java.io.File;

public class Satellite {
    static int[][] oldImg, newImg;
    static int r, c;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input.txt"));
        r = sc.nextInt(); c = sc.nextInt();
        readImage(sc, oldImg = new int[r][c]);
        readImage(sc, newImg = new int[r][c]);
        System.out.printf("%d %d %d %d\n", get(true, true), get(false, true), get(true, false), get(false, false));
    }

    static void readImage(Scanner sc, int[][] img) {
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                img[i][j] = sc.nextInt();
    }

    static int get(boolean isR, boolean isMin) {
        int max = isR ? r : c;
        for (int i = isMin ? 0 : max - 1; i >= 0 && i < max; i += isMin ? 1 : -1)
            if (!isEq(i, isR)) return i + 1;
        return 0;
    }

    static boolean isEq(int idx, boolean isR) {
        for (int i = 0; i < (isR ? c : r); i++)
            if ((isR ? oldImg[idx][i] : oldImg[i][idx]) != (isR ? newImg[idx][i] : newImg[i][idx]))
                return false;
        return true;
    }
}