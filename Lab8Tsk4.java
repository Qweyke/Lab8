import java.util.Arrays;
import java.util.Scanner;

public class Lab8Tsk4 {
    public static void gnomeSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (i == 0 || arr[i - 1] <= arr[i]) {
                i++;
            }
            else {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int n = scan.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            int value = scan.nextInt();
            arr[i] = value;
        }

        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));

        System.out.println("Сортировка гномья: ");
        gnomeSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Сортировка пузырьком: ");
        bubbleSort(arrCopy);
        System.out.println(Arrays.toString(arrCopy));
    }
}

