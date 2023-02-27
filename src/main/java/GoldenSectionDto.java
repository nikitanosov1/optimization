import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoldenSectionDto {
    private double minX;
    private double functionValueInMinX;
    private double eps;
    private int recursionDeep;
    private int countOfCalc;
}
