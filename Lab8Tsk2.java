import java.util.*;
public class Lab8Tsk2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] mas1 = new int[N];
        int[] mas2 = new int[M];
        ArrayList<Integer> com3 = new ArrayList<>(); // массив общих эл
        for (int i = 0; i < N; i++) {
            mas1[i] = scan.nextInt();
        }
        for (int j = 0; j < M; j++) {
            mas2[j] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            System.out.print(mas1[i] + " ");
        }
        System.out.format("%n");
        for (int j = 0; j < M; j++) {
            System.out.print(mas2[j] + " ");
        }
        System.out.format("%n");
        for (int j = 0; j < N; j++) {
            int ctmas1 = 0;
            int ctmas2 = 0;
            for (int t = 0; t < N; t++) {
            if (mas1[j] == mas1[t]) {
                ctmas1++;
            }
            }
            if (!com3.contains(mas1[j])) { // проверка на повтор эл в 1 масе
                    for (int k = 0; k < M; k++) {
                        if (mas1[j] == mas2[k]) {
                            ++ctmas2;
                            if (!com3.contains(mas1[j])) {
                                com3.add(mas1[j]);
                            }
                        }
                    }
                }
                if (ctmas2 > 0) {
                    int[] resultForElement = {
                            mas1[j],
                            ctmas1,
                            ctmas2
                    };
                    System.out.println(Arrays.toString(resultForElement));
                }

            }
        }
    }





