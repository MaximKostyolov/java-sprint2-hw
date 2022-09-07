import java.util.HashMap;

public class MonthInfo {
    public static void getMonthInfo (HashMap<Integer, MonthlyReport> monthReports) {
        for (int i = 1; i <= 3; i++) {
            MonthlyReport monthlyReport = monthReports.get(i);
            System.out.println("Месяц: " + monthlyReport.getMonthName(i));
            System.out.println("Самый прибыльный товар: " + monthlyReport.getMostProfitItem());
            System.out.println("Самая большая трата: " + monthlyReport.getMostExpenseItem());
        }
    }
}
