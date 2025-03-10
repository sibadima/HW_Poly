package taxes;

public class ProfitTax extends TaxSystem {

    @Override
    public int calcTaxFor (int debit, int credit) {
        return Math.max( 0, (int) ((debit - credit) * 0.15)); //15% от доходов - расходы, но не меньше 0
    }

}
