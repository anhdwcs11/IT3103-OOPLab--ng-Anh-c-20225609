// 6.4
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DayofMonth {
    private static final Map<String, Integer> monthDays = new HashMap<>();
    private static final String[] monthNames = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    
    static {
        monthDays.put("January", 31);
        monthDays.put("Jan", 31);
        monthDays.put("Jan.", 31);
        monthDays.put("1", 31);
        monthDays.put("February", 28); 
        monthDays.put("Feb", 28);
        monthDays.put("Feb.", 28);
        monthDays.put("2", 28);
        monthDays.put("March", 31);
        monthDays.put("Mar", 31);
        monthDays.put("Mar.", 31);
        monthDays.put("3", 31);
        monthDays.put("April", 30);
        monthDays.put("Apr", 30);
        monthDays.put("Apr.", 30);
        monthDays.put("4", 30);
        monthDays.put("May", 31);
        monthDays.put("5", 31);
        monthDays.put("June", 30);
        monthDays.put("Jun", 30);
        monthDays.put("Jun.", 30);
        monthDays.put("6", 30);
        monthDays.put("July", 31);
        monthDays.put("Jul", 31);
        monthDays.put("Jul.", 31);
        monthDays.put("7", 31);
        monthDays.put("August", 31);
        monthDays.put("Aug", 31);
        monthDays.put("Aug.", 31);
        monthDays.put("8", 31);
        monthDays.put("September", 30);
        monthDays.put("Sep", 30);
        monthDays.put("Sep.", 30);
        monthDays.put("9", 30);
        monthDays.put("October", 31);
        monthDays.put("Oct", 31);
        monthDays.put("Oct.", 31);
        monthDays.put("10", 31);
        monthDays.put("November", 30);
        monthDays.put("Nov", 30);
        monthDays.put("Nov.", 30);
        monthDays.put("11", 30);
        monthDays.put("December", 31);
        monthDays.put("Dec", 31);
        monthDays.put("Dec.", 31);
        monthDays.put("12", 31);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monthInput;
        int year = -1;
        
        // Get valid month input
        while (true) {
            System.out.print("Enter the month (full name, abbreviation, or number): ");
            monthInput = scanner.next().trim();
            if (monthDays.containsKey(monthInput)) {
                break; // valid month input
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }
        
       
        while (true) {
            System.out.print("Enter the year (non-negative integer): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) {
                    break; 
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid year. Please enter a non-negative integer.");
        }
        int daysInMonth = monthDays.get(monthInput);
        if ("February".equalsIgnoreCase(monthInput) && isLeapYear(year)) {
            daysInMonth = 29; 
        }
        System.out.printf("The month of %s in the year %d has %d days.%n", monthInput, year, daysInMonth);
        scanner.close();
    }
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
