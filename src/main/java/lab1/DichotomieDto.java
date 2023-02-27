package lab1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DichotomieDto {
    private double minX;
    private double functionValueInMinX;
    private double eps;
    private int count;
}
