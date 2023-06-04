import java.util.Scanner;
public class Lab8Tsk12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер квадратной матрицы: ");
        int n = sc.nextInt();
        int[][] a = new int[n][n];

        System.out.println("Введите элементы матрицы A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[][] a_inverse = new int[n][n];

        System.out.println("Введите элементы обратной матрицы A-1:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a_inverse[i][j] = sc.nextInt();
            }
        }

        // Проверяем выполняется ли условие A * A-1 = E
        boolean check = multiply(a, a_inverse);

        if (check) {
            System.out.println("Матрицы A и A-1 корректны");
        } else {
            System.out.println("Ошибка в обратной матрице или исходных данных");
        }
    }

    public static boolean multiply(int[][] a, int[][] inverse) {

        int[][] result = multiplyMatrix(a, inverse);
        int[][] e = createUnitMatrix(a.length);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (result[i][j] != e[i][j]) return false;
            }
        }
        return true;
    }
    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    public static int[][] createUnitMatrix(int n) {
        int[][] e = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) e[i][j] = 1;
                else e[i][j] = 0;
            }
        }
        return e;
    }

}
