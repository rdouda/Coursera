import org.junit.Test;
import static org.junit.Assert.*;

public class MoneySumTest {
    @Test(expected = UniteDistincteException.class)
    public void testAddDistinctUnits() throws UniteDistincteException {
        MoneySum m12DT = new MoneySum(12, "DT");
        MoneySum m14USD = new MoneySum(14, "USD");

        m12DT.add(m14USD);
    }
}
