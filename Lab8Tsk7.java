import java.util.Scanner;
public class Lab8Tsk7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер мтарицы");
        int n = scan.nextInt();
        int[][] spiral = new int[n][n];

        int num = n * n;   // Начальное значение
        int minRow = 0;
        int minCol = 0;
        int maxRow = n - 1;
        int maxCol = n - 1;
        if (n % 2 == 0) even(minRow, minCol, maxCol, maxRow, num, spiral);
        else odd(minRow, minCol, maxCol, maxRow, num, spiral);
        out(n, spiral);


    }

    private static void even(int minRow, int minCol, int maxCol, int maxRow, int num, int[][] spiral) {

        while (num >= 1) {
            // Левая граница
            for (int i = minRow; i <= maxRow; i++) {
                spiral[i][minCol] = num--;
            }
            minCol++;///????

            // Нижняя граница
            for (int i = minCol; i <= maxCol; i++) {
                spiral[maxRow][i] = num--;
            }
            maxRow--;

            // Правая граница
            for (int i = maxRow; i >= minRow; i--) {
                spiral[i][maxCol] = num--;
            }
            maxCol--;


            // Верхняя граница
            for (int i = maxCol; i >= minCol; i--) {
                spiral[minRow][i] = num--;
            }
            minRow++;
        }

    }
    private static void odd(int minRow, int minCol, int maxCol, int maxRow, int num, int[][] spiral) {

        while (num >= 1) {
            // Правая граница
            for (int i = maxRow; i >= minRow; i--) {
                spiral[i][maxCol] = num--;
            }
            maxCol--;

            // Верхняя граница
            for (int i = maxCol; i >= minCol; i--) {
                spiral[minRow][i] = num--;
            }
            minRow++;

            // Левая граница
            for (int i = minRow; i <= maxRow; i++) {
                spiral[i][minCol] = num--;
            }
            minCol++;

            // Нижняя граница
            for (int i = minCol; i <= maxCol; i++) {
                spiral[maxRow][i] = num--;
            }
            maxRow--;

        }

    }

    public static void out(int n, int[][] spiral) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (spiral[i][j] < 10) {
                    System.out.print(" " + spiral[i][j] + " ");
                } else {
                    System.out.print(spiral[i][j] + " ");
                }
            }
                System.out.println();
            }
        }
    }





