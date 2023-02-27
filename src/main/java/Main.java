import lab1.FibbonachiDto;
import lab1.Functions;

class Main {
    public static void main(String[] args) {
        double a = 2.5;
        double b = 4.0;
        double eps = Math.pow(10, -6);
        int n = 20;
        // double delta = Math.pow(10, -4);
        // lab1.DichotomieDto dto = lab1.Functions.dichotomie(a, b, eps, delta);
        // lab1.GoldenSectionDto dto = lab1.Functions.goldenSection(a, b, eps);
        FibbonachiDto dto = Functions.fibbonachiSection(a, b, n);
        System.out.println(dto);
    }
}