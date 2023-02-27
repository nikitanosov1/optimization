public class Functions {
    static private MyFunction f = new MyFunction();
    static final private double phi = (1 + Math.sqrt(5)) / 2;

    public static DichotomieDto dichotomie(double l, double r, double eps, double delta) {
        //System.out.println(l + " " + r + " " + eps);
        if (r - l < 2 * delta) {
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

        DichotomieDto dich;
        if (funInA < funInB) {
            dich = dichotomie(l, newR, eps, delta);
        } else {
            dich = dichotomie(newL, r, eps, delta);
        }
        dich.setCount(dich.getCount() + 2);
        return dich;
    }

    public static GoldenSectionDto goldenSection(double a, double b, double eps) {
        double x1 = b - (b - a) / phi;
        double x2 = a + (b - a) / phi;

        double y1 = f.apply(x1);
        double y2 = f.apply(x2);

        GoldenSectionDto dto = null;
        if (y1 > y2) {
            dto = goldenSectionRecursion(x1, b, KnewState.KNEW_X1, x2, y2, eps);
        } else {
            dto = goldenSectionRecursion(a, x2, KnewState.KNEW_X2, x1, y1, eps);
        }
        return dto;
    }

    static private GoldenSectionDto goldenSectionRecursion(double a, double b, KnewState state, double knewValue, double knewY, double eps) {
        System.out.println(a + " " + b + " " + state + " " + knewValue);
        if (b - a < 2 * eps) {
            return GoldenSectionDto.builder()
                    .minX((a + b) / 2)
                    .functionValueInMinX(f.apply((a + b) / 2))
                    .eps((b - a) / 2)
                    .recursionDeep(0)
                    .countOfCalc(0)
                    .build();
        }

        GoldenSectionDto dto;
        Double x1 = null;
        Double x2 = null;
        Double y1 = null;
        Double y2 = null;
        switch (state) {
            case KNEW_X1:
                x1 = knewValue;
                y1 = knewY;
                x2 = a + (b - a) / phi;
                y2 = f.apply(x2);
                break;
            case KNEW_X2:
                x2 = knewValue;
                y2 = knewY;
                x1 = b - (b - a) / phi;
                y1 = f.apply(x1);
                break;
        }
        System.out.println("x1 = " + x1 + " x2 = " + x2);

        if (y1 < y2) {
            dto = goldenSectionRecursion(a, x2, KnewState.KNEW_X2, x1, y1, eps);
        } else {
            dto = goldenSectionRecursion(x1, b, KnewState.KNEW_X1, x2, y2, eps);
        }
        dto.setRecursionDeep(dto.getRecursionDeep() + 1);
        dto.setCountOfCalc(dto.getCountOfCalc() + 1);
        return dto;
    }

    public static FibbonachiDto fibbonachiSection(double a, double b, int n) {
        int[] fibs = new int[n];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i < n; ++i) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        n -= 1;
        double x1 = a + fibs[n] * (b - a) / fibs[n + 2];
        double x2 = a + fibs[n + 1] * (b - a) / fibs[n + 2];

        

    }
}
