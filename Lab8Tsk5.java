public class Lab8Tsk5 {

    public static void swapDiagonals(int[][] matrix) {

        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i == j) {  // Элемент на главной диагонали

                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][size - 1 - j];
                    matrix[j][size - 1 - j] = temp;
                }

                if (i + j == size - 1) { // Элемент на побочной диагонали

                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[size - 1 - i][size - 1 - j];
                    matrix[size - 1 - i][size - 1 - j] = temp;
                }
            }
        }
    }



    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        swapDiagonals(matrix);

        System.out.println("Матрица после обмена диагоналей:");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {

            for (int anInt : ints) {

                System.out.print(anInt + " ");

            }

            System.out.println();


        }
    }
}


