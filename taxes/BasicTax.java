package taxes;

public class BasicTax extends TaxSystem {

    @Override
    public int calcTaxFor (int debit, int credit) {
        return (int) (debit * 0.06); //6% от доходов
    }

}
