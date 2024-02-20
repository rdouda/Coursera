public class Main {
    public static void main(String[] args) {
        try {
            MoneySum m1 = new MoneySum(10, "USD");
            MoneySum m2 = new MoneySum(15, "EUR");

            MoneySum result = m1.add(m2);
            System.out.println("Result: " + result.getQuantity() + " " + result.getUnit());
        } catch (UniteDistincteException e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
