import java.util.*;
import static java.lang.Math.*;
public class Lab8Tsk1 {
    public static void main(String[] args) {
        System.out.println("Pls, enter the length of the array");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        double S = 0; // сумма из 2 в 10
        int[] binary = new int[N];
        int[] decimal = new int[N];
        int M = N;
        for (int i = 0; i < N; i++) { // заполенеие 2 массива
            System.out.println("Pls, enter the binary digits to fill in the number-array\n" + M);
            int m = scan.nextInt();
            while (m != 0 && m != 1) { // проверка польз
                System.out.println("Pls enter 0 or 1");
                m = scan.nextInt();
                if (m == 0 || m == 1) {
                    break;
                }
            }
            binary[i] = m;
            M--;
        }
        for (int k = N - 1; k >= 0; k--) {
            S += pow(2, (-1 * (k + 1))) * binary[k]; // из 2 в 10
        }
        S = round(S * 1000000d) / 1000000d; // округление до 6 цифр после
        S *= (pow(10, N)); // преобразование без ","
        int Si = (int) S;
        for (int j = N - 1; j >= 0; j--) {
            decimal[j] = Si % 10; // массив 10 заполнение
            Si /= 10;
        }
        for (int j = 0; j < N; j++) {
            System.out.print(binary[j]); // 2 вывод
        }
        System.out.print(' ');
        if (N <= 6) {
            for (int j = 0; j < N; j++) {
                System.out.print(decimal[j]);// вывод 10
            }
        } else {
            for (int j = 0; j < 6; j++) {
                System.out.print(decimal[j]);// вывод 10
            }
        }
    }
}

