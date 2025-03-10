import taxes.TaxSystem;

public class Company {
    private String title; // название компании
    private int debit = 0; // доходы компании
    private int credit = 0; // расходы компании
    private TaxSystem taxSystem; // система налогообложения


    //Конструктор
    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + tax + " руб.");
        debit = 0;
        credit = 0;
    }

    public int shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        }
        if (amount < 0) {
            credit += Math.abs(amount);
        }
        return amount;
    }



    public int applyDeals(Deal[] deals) {
        int initialBalance = debit - credit; //разница доходов и расходов до применения сделок

        for (Deal deal : deals) {
            debit += deal.getDebitChange();
            credit += deal.getCreditChange();
            System.out.println(deal.getComment()); //вывод комментария сделки
        }

        payTaxes(); //выплата налогов
        return initialBalance;
    }


}