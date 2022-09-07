import java.util.ArrayList;

public class MonthlyRecord {

    String itemName;
    boolean isExpense;
    int quantity;
    int sumOfOne;

    public MonthlyRecord(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    public static ArrayList createMonthlyReport (String monthlyReportRow) {
        String[] lines = monthlyReportRow.split("\n");
        ArrayList<MonthlyRecord> monthlyRecords = new ArrayList<>();
        for (int j = 1; j < lines.length; j++) {
            String[] lineContents = lines[j].split(",");
            MonthlyRecord record = new MonthlyRecord(
                    lineContents[0],
                    Boolean.parseBoolean(lineContents[1]),
                    Integer.parseInt(lineContents[2]),
                    Integer.parseInt(lineContents[3])
            );
            monthlyRecords.add(record);
        }
        return monthlyRecords;
    }
}
