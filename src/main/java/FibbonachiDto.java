import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FibbonachiDto {
    private double minX;
    private double functionValueInMinX;
    private double eps;
    private int count;
}