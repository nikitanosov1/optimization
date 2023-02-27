class Main {
    public static void main(String[] args) {
        double a = 2.5;
        double b = 4.0;
        double eps = Math.pow(10, -6);
        int n = 20;
        // double delta = Math.pow(10, -4);
        // DichotomieDto dto = Functions.dichotomie(a, b, eps, delta);
        // GoldenSectionDto dto = Functions.goldenSection(a, b, eps);
        FibbonachiDto dto = Functions.fibbonachiSection(a, b, n);
        System.out.println(dto);
    }
}