import java.util.ArrayList;

public class YearlyReport {

    private int year;
    private ArrayList<YearlyRecord> yearlyReports;

    public YearlyReport(int year, ArrayList<YearlyRecord> yearlyReports) {
        this.year = year;
        this.yearlyReports = yearlyReports;
    }

    public int getYear() {
        return year;
    }

    public int getYearlyIncomeByMonth(int month) {
        int incomeByMonth = 0;
        for (YearlyRecord record : yearlyReports) {
            if ((record.isExpense == false) & (record.month == month)) {
                incomeByMonth = record.amount;
            }
        }
        return incomeByMonth;
    }

    public int getYearlyOutcomeByMonth(int month) {
        int outcomeByMonth = 0;
        for (YearlyRecord record : yearlyReports) {
            if ((record.isExpense == true) && (record.month == month)) {
                outcomeByMonth = record.amount;
            }
        }
        return outcomeByMonth;
    }

    public int getYearlyAverageIncome() {
        int totalIncome = 0;
        for (YearlyRecord record : yearlyReports) {
            if (record.isExpense == false) {
                totalIncome = totalIncome + record.amount;
            }
        }
        int averageIncome = totalIncome / 3;
        return averageIncome;
    }

    public int getYearlyAverageOutcome() {
        int totalOutcome = 0;
        for (YearlyRecord record : yearlyReports) {
            if (record.isExpense == true) {
                totalOutcome = totalOutcome + record.amount;
            }
        }
        int averageOutcome = totalOutcome / 3;
        return averageOutcome;
    }

    public void findProfitByMonth() {
        int outcome = 0;
        int income = 0;
        for (int i = 1; i <= 3; i++) {
            outcome = getYearlyOutcomeByMonth(i);
            income = getYearlyIncomeByMonth(i);
            int profit = income - outcome;
            if (profit > 0) {
                System.out.println("Месяц №" + i + ": прибыль: " + profit + " руб.");
            } else {
                System.out.println("Месяц №" + i + ": убыль: " + profit + " руб.");
            }
        }
    }
}
