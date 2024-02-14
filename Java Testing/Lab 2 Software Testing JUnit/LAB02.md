## MoneySum Class Test - equals() Method

1. **Test: Check for non-equality with different currencies**
    ```java
    MoneySum m14DT = new MoneySum(14, "DT");
    MoneySum m14USD = new MoneySum(14, "USD");
    Assert.assertTrue(!m14USD.equals(m14DT));
    ```

    This test ensures that the `equals()` method correctly identifies non-equality when comparing `MoneySum` objects with different currencies.

2. 
    ```java
    import org.junit.Before;
    import org.junit.Test;
    import org.junit.Assert;

    public class MoneySumTest {

        private MoneySum m12DT;
        private MoneySum m14DT;
        private MoneySum m14USD;

        @Before
        public void setup() {
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
3. 
    The setup() method annotated with @Before is responsible for initializing and setting up the test fixtures before each test method is executed.

4. 
    ```java
    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;
    import org.junit.Assert;

    public class MoneySumTest {

        private MoneySum m12DT;
        private MoneySum m14DT;
        private MoneySum m14USD;

        @Before
        public void setup() {
            System.out.println("1st pass before execution of a test method");
            m12DT = new MoneySum(12, "DT");
            m14DT = new MoneySum(14, "DT");
            m14USD = new MoneySum(14, "USD");
        }

        @After
        public void afterFirstPass() {
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

        @After
        public void afterSecondPass() {
            System.out.println("2nd pass AFTER execution of a test method");
        }
    }
    ```
    Output:
    ```
    1st pass before execution of a test method
    1st pass AFTER execution of a test method
    2nd pass before execution of a test method
    2nd pass AFTER execution of a test method
    ```
5. 
    - [UniteDistincteException](UniteDistincteException.java)
    - [MoneySum](MoneySum.java)