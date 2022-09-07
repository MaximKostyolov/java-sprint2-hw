import java.util.ArrayList;
import java.util.HashMap;

public class CompareReports {

    public static void compareReports(HashMap<Integer, MonthlyReport> monthReports, ArrayList<YearlyReport> yearReports) {
        YearlyReport yearlyRecords = yearReports.get(0);
        boolean compare = true;
        for (int i = 1; i <= 3; i++) {
            MonthlyReport monthlyReport = monthReports.get(i);
            if ((monthlyReport.getMonthlyTotalIncome() != yearlyRecords.getYearlyIncomeByMonth(i)) || ((monthlyReport.getMonthlyTotalOutcome()) != yearlyRecords.getYearlyOutcomeByMonth(i))) {
                System.out.println("Отчеты не прошли проверку");
                System.out.println("В " + i + "месяце есть расхождения");
                compare = false;
            }
        }
        if (compare) {
            System.out.println("Отчеты успешно прошли проверку");
        }
    }
    }

