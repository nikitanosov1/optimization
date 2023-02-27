import java.util.function.Function;

public class MyFunction implements Function<Double, Double> {
    @Override
    public Double apply(Double x) {
        return Math.exp(x - 1 + 1 / (x - 2));
    }
}
