public class QuadraticEquation {
    public static void main(String[] args) {
        int a = 1;
        int b = 5;
        int c = 1;
        String result = quadraticEquation(a, b, c);
        System.out.println(result);
    }

    public static String quadraticEquation(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        String result = "";
        double solution1;
        double solution2;
        if (delta > 0) {
            solution1 = -b - Math.sqrt(delta) / (2 * a);
            solution2 = -b + Math.sqrt(delta) / (2 * a);
            return result + solution1+"\n" + solution2;
        } else if (delta == 0) {
            solution1 = -b / 2 * a;
            return result + solution1;
        } else {
            return result + "Phương trình vô nghiệm";
        }
    }
}
