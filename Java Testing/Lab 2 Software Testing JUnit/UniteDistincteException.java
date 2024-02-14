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