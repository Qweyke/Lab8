import java.util.Scanner;
public class Lab8Tsk6 {
    // n - строки
    static int n;

    // m - столбцы
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите кол-во строк");
        int n = sc.nextInt();
        System.out.println("Введите кол-во столбцов");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = (int)(Math.random() * 100);
        System.out.println("Введите бескон малое");
        double delta = sc.nextDouble();


        if (delta >= 1) {
            System.out.println("Погрешность должна быть бесконечно малой!");
            return;
        }

        int[][] averageStudents = getAverageStudents(matrix, 0, delta);
        int[] uniqueStudent = getUniqueStudent(matrix, 0, delta);

        printResults(averageStudents, uniqueStudent);
    }

    public static double getAverage(int[][] matrix, int col) {

        int sum = 0;
        for (int[] ints : matrix) {
            sum += ints[col];
        }

        return (double) sum / matrix.length;
    }

    public static int[][] getAverageStudents(int[][] matrix, int col, double delta) {

        double average = getAverage(matrix, col);

        int[][] result = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(matrix[i][col] - average) <= delta+ 0.00001) {
                result[count++] = matrix[i];
            }
            if (count == result.length) break;
        }
        return result;
    }

    public static int[] getUniqueStudent(int[][] matrix, int col, double delta) {

        double minDiff = Double.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < n; i++) {
            double diff = Math.abs(matrix[i][col] - getAverage(matrix, col));
            if (diff < minDiff && diff <= delta+ 0.00001){
                minDiff = diff;
                index = i;
            }
        }
        return matrix[index];
    }
    public static void printResults(int[][] average, int[] unique) {
        System.out.println("Среднестатистики:");
        for (int[] row : average) {

            // Вывод данных одного студента
            System.out.println(row[0] + " " +
                    row[1] + " " +
                    row[2] + " " +
                    row[3]);
        }

        System.out.println("Уникальный студент:");
        System.out.println(unique[0] + " " +
                unique[1] + " " +
                unique[2] + " " +
                unique[3]);
    }
}

