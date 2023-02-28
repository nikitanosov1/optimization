import lab1.FibbonachiDto;
import lab1.Functions;

class Main {
    public static void main(String[] args) {
        double a = 2.5;
        double b = 4.0;
        double eps = Math.pow(10, -5);
        int n = 26;
        // double delta = Math.pow(10, -4);
        // lab1.DichotomieDto dto = lab1.Functions.dichotomie(a, b, eps, delta);
        //lab1.GoldenSectionDto dto = lab1.Functions.goldenSection(a, b, eps);
        lab1.FibbonachiDto dto = Functions.fibbonachiSection(a, b, n);
        System.out.println(dto);
        // golden eps=7.233656758698359E-6 за 26 шагов
        // fibo    eps=6.178286316105286E-6 за 26 шагов
    }
}