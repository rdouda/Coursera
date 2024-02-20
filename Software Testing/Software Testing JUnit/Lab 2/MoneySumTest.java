import org.junit.Test;
import static org.junit.Assert.assertThrows;

public class MoneySumTest {

    private MoneySum m12DT;
    private MoneySum m14DT;
    private MoneySum m14USD;

    @Before
    public void setUp() {
        m12DT = new MoneySum(12, "DT");
        m14DT = new MoneySum(14, "DT");
        m14USD = new MoneySum(14, "USD");
    }

    @Test
    public void testEqualsMethod() {
        Assert.assertTrue(!m12DT.equals(null));
        Assert.assertEquals(m12DT, m12DT);
        Assert.assertEquals(m12DT, new MoneySum(12, "DT"));
        Assert.assertTrue(!m12DT.equals(m14DT));
        Assert.assertTrue(!m14USD.equals(m14DT));
    }

    @Test
    public void testAddDistinctUnits() {
        MoneySum m1 = new MoneySum(10, "USD");
        MoneySum m2 = new MoneySum(15, "EUR");

        UniteDistincteException exception = assertThrows(UniteDistincteException.class, () -> {
            m1.add(m2);
        });
    }
}
