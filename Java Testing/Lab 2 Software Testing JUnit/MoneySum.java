public class MoneySum {
    private double quantity;
    private String unit;

    public MoneySum add(MoneySum m) throws UniteDistincteException {
        if (!m.getUnit().equals(this.getUnit())) {
            throw new UniteDistincteException(this, m);
        } else {
            return new MoneySum(getQuantity() + m.getQuantity(), getUnit());
        }
    }

}
