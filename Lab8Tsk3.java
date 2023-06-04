import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Lab8Tsk3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        // Ввод количества точек N
        System.out.print("Введите N: ");
        int n = scan.nextInt();

        // Массивы координат x и y размера 2N
        int[] x = new int[2 * n];
        int[] y = new int[2 * n];

        // Заполняем координаты x и y числами от 1 до 10
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0)
                x[i] = rand.nextInt(10) + 1;
            else
                y[i / 2] = rand.nextInt(10) + 1;
        }

        // Выводим массив координат точек
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        // Ввод центров и радиусов кругов
        System.out.print("Введите x1: ");
        int x1 = scan.nextInt();
        System.out.print("Введите y1: ");
        int y1 = scan.nextInt();
        System.out.print("Введите радиус R1: ");
        int R1 = scan.nextInt();

        System.out.print("Введите x2: ");
        int x2 = scan.nextInt();
        System.out.print("Введите y2: ");
        int y2 = scan.nextInt();
        System.out.print("Введите радиус R2: ");
        int R2 = scan.nextInt();

        // Метод для подсчета точек в кольцевой области


        System.out.println("Точек в кольцевой области: " + countPointsInRing(x,y,n,x1,y1,R1,x2,y2,R2));
    }
    public static int countPointsInRing(int[] x, int[] y, int n,
                                        int x1, int y1, int R1,
                                        int x2, int y2, int R2) {

        int pointsInRing = 0;

        for (int i = 0; i < n; i++) {

            int xPoint = x[2 * i];
            int yPoint = y[i];

            // Проверяем попала ли точка в кольцевую область
            if (((xPoint - x1) * (xPoint - x1) + (yPoint - y1) * (yPoint - y1)) >= R1 * R1 &&
                    ((xPoint - x2) * (xPoint - x2) + (yPoint - y2) * (yPoint - y2)) <= R2 * R2) {

                pointsInRing++;
            }
        }

        return pointsInRing;
    }
}
