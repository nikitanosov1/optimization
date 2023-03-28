package lab1;

import java.util.function.Function;

public class Functions {
    static final private double phi = (1 + Math.sqrt(5)) / 2;

    public static DichotomieDto dichotomie(double l, double r, double eps, double delta, Function<Double, Double> f) {
        System.out.println(l + " " + r);
        if (r - l < 2 * delta) {;
            return DichotomieDto.builder()
                    .minX((l + r) / 2)
                    .functionValueInMinX(f.apply((l + r) / 2))
                    .eps((r - l) / 2)
                    .count(0)
                    .build();
        }

        double mid = (l + r) / 2;

        double newL = mid - eps / 2;
        double newR = mid + eps / 2;

        double funInA = f.apply(newL);
        double funInB = f.apply(newR);
        //System.out.println(l + " " + r + " funInA = " + funInA + " funInB = " + funInB);
        DichotomieDto dich;
        if (funInA < funInB) {
            dich = dichotomie(l, newR, eps, delta, f);
        } else {
            dich = dichotomie(newL, r, eps, delta, f);
        }
        dich.setCount(dich.getCount() + 2);
        return dich;
    }

    public static GoldenSectionDto goldenSection(double a, double b, double eps, Function<Double, Double> f) {
        double x1 = b - (b - a) / phi;
        double x2 = a + (b - a) / phi;

        double y1 = f.apply(x1);
        double y2 = f.apply(x2);

        GoldenSectionDto dto = null;
        if (y1 > y2) {
            dto = goldenSectionRecursion(x1, b, KnewState.KNEW_X1, x2, y2, eps, f);
        } else {
            dto = goldenSectionRecursion(a, x2, KnewState.KNEW_X2, x1, y1, eps, f);
        }
        dto.setCountOfCalc(dto.getCountOfCalc() + 2);
        return dto;
    }

    static private GoldenSectionDto goldenSectionRecursion(double a, double b, KnewState state, double knewValue, double knewY, double eps, Function<Double, Double> f) {
        // System.out.println(a + " " + b + " " + state + " " + knewValue);
        if (b - a < 2 * eps) {
            return GoldenSectionDto.builder()
                    .minX((a + b) / 2)
                    .functionValueInMinX(f.apply((a + b) / 2))
                    .eps((b - a) / 2)
                    .recursionDeep(0)
                    .countOfCalc(1)
                    .build();
        }

        GoldenSectionDto dto;
        Double x1 = null;
        Double x2 = null;
        Double y1 = null;
        Double y2 = null;
        switch (state) {
            case KNEW_X1 -> {
                x1 = knewValue;
                y1 = knewY;
                x2 = a + (b - a) / phi;
                y2 = f.apply(x2);
            }
            case KNEW_X2 -> {
                x2 = knewValue;
                y2 = knewY;
                x1 = b - (b - a) / phi;
                y1 = f.apply(x1);
            }
        }

        if (y1 < y2) {
            dto = goldenSectionRecursion(a, x2, KnewState.KNEW_X2, x1, y1, eps, f);
        } else {
            dto = goldenSectionRecursion(x1, b, KnewState.KNEW_X1, x2, y2, eps, f);
        }
        dto.setRecursionDeep(dto.getRecursionDeep() + 1);
        dto.setCountOfCalc(dto.getCountOfCalc() + 1);
        return dto;
    }

    public static FibbonachiDto fibbonachiSection(double a, double b, int n, Function<Double, Double> f) {
        // https://neerc.ifmo.ru/wiki/index.php?title=Метод_Фибоначчи
        // https://studfile.net/preview/1518469/page:3/
        int[] fibs = new int[n + 1];
        fibs[0] = 1;
        fibs[1] = 1;
        for (int i = 2; i <= n; ++i) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        double x1 = a + fibs[n - 2] * (b - a) / fibs[n];
        double x2 = b - fibs[n - 2] * (b - a) / fibs[n];

        double y1 = f.apply(x1);
        double y2 = f.apply(x2);

        if (y1 < y2) {
            b = x2;
        } else {
            a = x1;
        }

        FibbonachiDto dto = null;
        if (y1 > y2) {
            dto = fibbonachiSectionRecursion(x1, b, KnewState.KNEW_X1, x2, y2, n - 2, fibs, f);
        } else {
            dto = fibbonachiSectionRecursion(a, x2, KnewState.KNEW_X2, x1, y1, n - 2, fibs, f);
        }
        dto.setCount(dto.getCount() + 2);
        return dto;
    }

    static private FibbonachiDto fibbonachiSectionRecursion(double a, double b, KnewState state, double knewX, double knewY, int n, int[] fibs, Function<Double, Double> f) {
        //System.out.println(a + " " + b + " " + state + " " + knewX);
        System.out.println(b - a);
        if (n <= 1) {
            return FibbonachiDto.builder()
                    .minX((a + b) / 2)
                    .functionValueInMinX(f.apply((a + b) / 2))
                    .eps((b - a) / 2)
                    .count(1)
                    .build();
        }

        FibbonachiDto dto;
        Double x1 = null;
        Double x2 = null;
        Double y1 = null;
        Double y2 = null;

        switch (state) {
            case KNEW_X1 -> {
                x1 = knewX;
                y1 = knewY;
                x2 = b - fibs[n - 2] * (b - a) / fibs[n];
                y2 = f.apply(x2);
            }
            case KNEW_X2 -> {
                x2 = knewX;
                y2 = knewY;
                x1 = a + fibs[n - 2] * (b - a) / fibs[n];
                y1 = f.apply(x1);
            }
        }
        if (y1 < y2) {
            dto = fibbonachiSectionRecursion(a, x2, KnewState.KNEW_X2, x1, y1, n - 1, fibs, f);
        } else {
            dto = fibbonachiSectionRecursion(x1, b, KnewState.KNEW_X1, x2, y2, n - 1, fibs, f);
        }
        dto.setCount(dto.getCount() + 1);
        return dto;
    }
}
