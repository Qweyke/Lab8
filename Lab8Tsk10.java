import java.util.Scanner;

public class Lab8Tsk10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Считываем координаты точек
        int N = sc.nextInt(); // Количество точек
        int[][] points = new int[N][2]; // Матрица координат Nx2
        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt(); // x
            points[i][1] = sc.nextInt(); // y
        }

        // Определяем попадание в область
        int[] result = checkPoints(points);

        // Вывод результатов
        printResults(result);
    }

    public static int[] checkPoints(int[][] points) {
        int[] result = new int[points.length];

        // Проверка попадания каждой точки в область
        for (int i = 0; i < points.length; i++) {

            // Условие, какая область
            if (points[i][0] >= 0 && points[i][1] >= 0) {
                result[i] = 1;  // Попала в область
            } else {
                result[i] = -1; // Вне области
            }
        }

        return result;
    }

    public static void printResults(int[] result) {
        for (int i = 0; i < result.length; i++) {

            if (result[i] == 1) {
                System.out.println("Точка " + (i + 1) + " попала внутрь области");
            } else {
                System.out.println("Точка " + (i + 1) + " вне области");
            }
        }
    }
}
