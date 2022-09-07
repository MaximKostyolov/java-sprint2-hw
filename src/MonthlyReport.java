import java.util.ArrayList;

public class MonthlyReport {

    private int month;
    private ArrayList<MonthlyRecord> monthlyReports;

    public MonthlyReport(int month, ArrayList<MonthlyRecord> monthlyReports) {
        this.month = month;
        this.monthlyReports = monthlyReports;
    }

    public int getMonthlyTotalIncome() {
        int totalIncome = 0;
        for (MonthlyRecord record: monthlyReports) {
            if (record.isExpense == false) {
                totalIncome = totalIncome + record.quantity * record.sumOfOne;
            }
        }
        return totalIncome;
    }

    public int getMonthlyTotalOutcome () {
        int totalOutcome = 0;
        for (MonthlyRecord record: monthlyReports) {
            if (record.isExpense == true) {
                totalOutcome = totalOutcome + record.quantity * record.sumOfOne;
            }
        }
        return totalOutcome;
    }

    public String getMostProfitItem () {
        String mostProfitItem = "";
        int maxProfit = 0;
        for (MonthlyRecord record: monthlyReports) {
            if (record.isExpense == false) {
                int profit = record.quantity * record.sumOfOne;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    mostProfitItem = record.itemName;
                }
            }
        }
        return mostProfitItem;
    }

    public String getMostExpenseItem () {
        String mostExpenseItem = "";
        int maxExpense = 0;
        for (MonthlyRecord record : monthlyReports) {
            if (record.isExpense == true) {
                int expense = record.quantity * record.sumOfOne;
                if (expense > maxExpense) {
                    maxExpense = expense;
                    mostExpenseItem = record.itemName;
                }
            }
        }
        return mostExpenseItem;
    }

    public static String getMonthName(int month) {
        String MonthName = "";
        if (month == 1) {
            MonthName = "Январь";
        } else if (month == 2) {
            MonthName = "Февраль";
        } else if (month == 3) {
            MonthName = "Март";
        }
        return MonthName;
    }
}