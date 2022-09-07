import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final HashMap<Integer, MonthlyReport> monthReports = new HashMap<>();
        final ArrayList<YearlyReport> yearReports = new ArrayList<>();

        printMenu();
        int userInput = 101;
        while (userInput == 101) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
            } else {
                System.out.println("Введено некорректное значение");
                printMenu();
            }
        }
        while (userInput != 0) { // обработка разных случаев
            if (userInput == 1) {
                for (int i = 1; i <= 3; i++) {
                    String montlyReportRow = readFileContentsOrNull("resources/m.20210" + i + ".csv");
                    MonthlyReport monthlyRecords = new MonthlyReport(
                            i,
                            MonthlyRecord.createMonthlyReport(montlyReportRow)
                    );
                    monthReports.put(i, monthlyRecords);
                }
                System.out.println("Месячные отчеты считаны");
            } else if (userInput == 2) {
                String yearlyReportRow  = readFileContentsOrNull("resources/y.2021.csv");
                YearlyReport yearlyRecords = new YearlyReport(
                        2021,
                        YearlyRecord.createYearlyReport(yearlyReportRow)
                );
                yearReports.add(yearlyRecords);
                System.out.println("Годовой отчет считан");
            } else if (userInput == 3) {
                if ((monthReports.isEmpty()) || (yearReports.isEmpty())) {
                    System.out.println("Отчеты не загружены. Считайте отчеты!");
                } else {
                    CompareReports.compareReports(monthReports, yearReports);
                }
            } else if (userInput == 4) {
                if (monthReports.isEmpty()) {
                    System.out.println("Месячные отчеты не загружены. Считайте месячные отчеты!");
                } else {
                    MonthInfo.getMonthInfo(monthReports);
                }
            } else if (userInput == 5) {
                if (yearReports.isEmpty()) {
                    System.out.println("Годовой отчет не загружен. Считайте годовой отчет!");
                } else {
                    YearInfo.getYearInfo(yearReports);
                }
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = 101; // повторное считывание данных от пользователя
            while (userInput == 101) {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    userInput = scanner.nextInt();
                } else {
                    System.out.println("Введено некорректное значение");
                    printMenu();
                }
            }
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() { // печать меню
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }

    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}