import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 2018-03-27.
 */
public class Test {


    public static void main(String[] args) {

        BigDecimal totalAmount = BigDecimal.valueOf(0.00);
        totalAmount = totalAmount.add(BigDecimal.valueOf(-878.34).multiply(BigDecimal.valueOf(1)));
        totalAmount = totalAmount.add(BigDecimal.valueOf(-1320.33).multiply(BigDecimal.valueOf(1)));

        System.out.println(totalAmount);

    }


}
