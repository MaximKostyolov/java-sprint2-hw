import java.util.ArrayList;

public class YearInfo {
    public static void getYearInfo(ArrayList<YearlyReport> yearReports) {
        YearlyReport yearlyReport = yearReports.get(0);
        System.out.println("Год: " + yearlyReport.getYear());
        yearlyReport.findProfitByMonth();
        System.out.println("Средний расход за все месяцы:" + yearlyReport.getYearlyAverageOutcome());
        System.out.println("Средний доход за все месяцы: " + yearlyReport.getYearlyAverageIncome());
    }
}
