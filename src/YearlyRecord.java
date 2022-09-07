import java.util.ArrayList;

public class YearlyRecord {

    int month;
    int amount;
    boolean isExpense;

    public YearlyRecord(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public static ArrayList<YearlyRecord> createYearlyReport (String yearlyReportRow) {
        String[] lines = yearlyReportRow.split("\n");
        ArrayList<YearlyRecord> yearlyRecords = new ArrayList<>();
        for (int j = 1; j < lines.length; j++) {
            String[] lineContents = lines[j].split(",");
            YearlyRecord record = new YearlyRecord(
                    Integer.parseInt(lineContents[0]),
                    Integer.parseInt(lineContents[1]),
                    Boolean.parseBoolean(lineContents[2])
            );
            yearlyRecords.add(record);
        }
        return yearlyRecords;
    }
}
