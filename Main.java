import taxes.BasicTax;
import taxes.ProfitTax;
import taxes.TaxSystem;

public class Main {
    public static void main(String[] args) {

        //создадим системы налогообложения
        TaxSystem basicTax = new BasicTax();
        TaxSystem profitTax = new ProfitTax();

        //создадим компании с разными системами налогообложения
        Company companyA = new Company("СОЮЗ", basicTax);
        Company companyB = new Company("Фаворит", profitTax);

        //тестируем УСН доходы
        companyA.shiftMoney(1000);
        companyA.shiftMoney(-300);
        companyA.payTaxes();

        //тестируем УСН доходы минус расходы
        System.out.println();
        companyB.shiftMoney(1000);
        companyB.shiftMoney(-300);
        companyB.payTaxes();

        //тестируем нулевой доход и расход
        System.out.println();
        companyA.shiftMoney(0);
        companyA.payTaxes();

        //тестируем отрицательную прибыль
        System.out.println();
        companyB.shiftMoney(-1000);
        companyB.payTaxes();

        //тестируем второе задание
        System.out.println();

        companyA.shiftMoney(1000);
        companyA.shiftMoney(-300);

        Deal[] deals = {
                new Sale("Куртки", 500_000),
                new Expenditure("Реклама", 120_000),
                new Sale("Термобелье", 100_000)
        };
        int result = companyA.applyDeals(deals);
        System.out.println("Разница доходов и расходов до уплаты налогов: " + result + " руб.");
    }
}
