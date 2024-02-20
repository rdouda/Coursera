# Lab 2 Software Testing JUnit

### **1.** Test for Comparing with Different Currency
```java
import org.junit.Assert;
import org.junit.Test;

public class MoneySumTest {
    @Test
    public void testEqualsMethod() {
        MoneySum m12DT = new MoneySum(12, "DT");
        MoneySum m14DT = new MoneySum(14, "DT");
        MoneySum m14USD = new MoneySum(14, "USD");

        Assert.assertTrue(!m12DT.equals(null));
        Assert.assertEquals(m12DT, m12DT);
        Assert.assertEquals(m12DT, new MoneySum(12, "DT"));
        Assert.assertTrue(!m12DT.equals(m14DT));
        Assert.assertTrue(!m14USD.equals(m14DT));
    }
}
```
Test when comparing with a MoneySum with a different currency

### **2.** Using setUp() Method for Test Initialization
```java
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
```
The **setUp()** method is executed before each test method.

### **3.** Test Fixture
Test fixture (also called "test context") is used to set up system state and input data needed for test execution.

### **4.** Using @Before and @After Annotations
```java
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneySumTest {

    private MoneySum m12DT;
    private MoneySum m14DT;
    private MoneySum m14USD;

    @Before
    public void setUp() {
        System.out.println("1st pass before execution of a test method");
        m12DT = new MoneySum(12, "DT");
        m14DT = new MoneySum(14, "DT");
        m14USD = new MoneySum(14, "USD");
    }

    // Code to be executed after each test method
    @After
    public void tearDown() {
        System.out.println("1st pass AFTER execution of a test method");
    }

    @Test
    public void testEqualsMethod() {
        Assert.assertTrue(!m12DT.equals(null));
        Assert.assertEquals(m12DT, m12DT);
        Assert.assertEquals(m12DT, new MoneySum(12, "DT"));
        Assert.assertTrue(!m12DT.equals(m14DT));
        Assert.assertTrue(!m14USD.equals(m14DT));
    }

    @Before
    public void setUpSecondPass() {
        System.out.println("2nd pass before execution of a test method");
    }

    @After
    public void tearDownSecondPass() {
        System.out.println("2nd pass AFTER execution of a test method");
    }
}
```

The **@Before** and **@After** annotations help in setting up and tearing down the test environment, ensuring a clean and consistent state for each test method.

- ### **5.** add() method has been modified.

```java
public class MoneySum {
    private double quantity;
    private String unit;

    public MoneySum(double quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public MoneySum add(MoneySum m) throws UniteDistincteException {
        if (!m.getUnit().equals(this.getUnit())) {
            throw new UniteDistincteException(this, m);
        } else {
            return new MoneySum(getQuantity() + m.getQuantity(), getUnit());
        }
    }
}


public class UniteDistincteException extends Exception {
    private MoneySum sum1, sum2;

    public UniteDistincteException(MoneySum sa1, MoneySum sa2) {
        sum1 = sa1;
        sum2 = sa2;
    }

    @Override
    public String toString() {
        return "Distinct unit: " + sum1.getUnit() + " != " + sum2.getUnit();
    }
}
```

- ### **5.1**
    - Added missing getQuantity() and getUnit() methods to the MoneySum class
    - Updated the add() method to use the correct getter methods

- ### **5.2** Test method throws a UniteDistincteException when m1 and m2 have distinct units.
```java
@Test
public void testAddDistinctUnits() {
    MoneySum m1 = new MoneySum(10, "USD");
    MoneySum m2 = new MoneySum(15, "EUR");

    UniteDistincteException exception = assertThrows(UniteDistincteException.class, () -> {
        m1.add(m2);
    });
}
```
