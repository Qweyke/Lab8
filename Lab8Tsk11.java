import java.util.*;
public class Lab8Tsk11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во треугольников:");
        int n = scanner.nextInt();
        double[][] vertices = new double[2][3 * n];
        for (int i = 0; i < 3 * n; i++) {
            vertices[i % 2][i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            double[] v1 = {vertices[0][3 * i], vertices[1][3 * i]};
            double[] v2 = {vertices[0][3 * i + 1], vertices[1][3 * i + 1]};
            double[] v3 = {vertices[0][3 * i + 2], vertices[1][3 * i + 2]};
            double a = dist(v1, v2);
            double b = dist(v2, v3);
            double c = dist(v3, v1);
            double s = area(a, b, c);
            if (Double.isNaN(s)) {
                System.out.printf("Треугольник %d: не существует.\n", i + 1);
            } else {
                int type = classify(a, b, c);
                String typeStr = getTypeString(type);
                int sides = getSides(a, b, c);
                String sidesStr = getSidesString(sides);
                System.out.printf("Треугольник %d: %s, %s, площадь = %.2f.\n", i + 1, typeStr, sidesStr, s);
            }
        }
        Set<Integer> sameAreaTriangles = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (vertices[0][3 * i] == vertices[0][3 * j] && vertices[1][3 * i] == vertices[1][3 * j] && vertices[0][3 * i + 1] == vertices[0][3 * j + 1] && vertices[1][3 * i + 1] == vertices[1][3 * j + 1] && vertices[0][3 * i + 2] == vertices[0][3 * j + 2] && vertices[1][3 * i + 2] == vertices[1][3 * j + 2]) {
                    sameAreaTriangles.add(i + 1);
                    sameAreaTriangles.add(j + 1);
                }
            }
        }
        if (!sameAreaTriangles.isEmpty()) {
            System.out.printf("Треугольники с одинаковой площадью: %s\n", sameAreaTriangles);
        }
    }

    private static double dist(double[] v1, double[] v2) {
        return Math.sqrt((v1[0] - v2[0]) * (v1[0] - v2[0]) + (v1[1] - v2[1]) * (v1[1] - v2[1]));
    }

    private static double area(double a, double b, double c) {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private static int classify(double a, double b, double c) {
        if (a == b && b == c) {
            return 1; // Равносторонний
        } else if (a == b || b == c || c == a) {
            return 2; // Равнобедренный
        } else {
            return 3; // Разносторонний
        }
    }

    private static int getSides(double a, double b, double c) {
        if (a == b && b == c) {
            return 3; // Три одинаковых стороны
        } else if (a == b || b == c || c == a) {
            return 2; // Две одинаковых стороны
        } else {
            return 0; // Нет одинаковых сторон
        }
    }

    private static String getTypeString(int type) {
        switch (type) {
            case 1:
                return "равносторонний";
            case 2:
                return "равнобедренный";
            case 3:
                return "разносторонний";
            default:
                return "некорректный тип треугольника";
        }
    }

    private static String getSidesString(int sides) {
        switch (sides) {
            case 0:
                return "нет одинаковых сторон";
            case 2:
                return "две одинаковых стороны";
            case 3:
                return "три одинаковых стороны";
            default:
                return "некорректное число одинаковых сторон";
        }
    }
}
