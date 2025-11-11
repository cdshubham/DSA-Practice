import java.util.*;

public class SortDates {
    public static void main(String[] args) {
        String[] dates = {
            "12041996", "20101996", "05061997", 
            "12041989", "11081987", "15091996"
        };

        Arrays.sort(dates, (d1, d2) -> {
            int day1 = Integer.parseInt(d1.substring(0, 2));
            int month1 = Integer.parseInt(d1.substring(2, 4));
            int year1 = Integer.parseInt(d1.substring(4));

            int day2 = Integer.parseInt(d2.substring(0, 2));
            int month2 = Integer.parseInt(d2.substring(2, 4));
            int year2 = Integer.parseInt(d2.substring(4));

            if (year1 != year2) return year1 - year2;
            if (month1 != month2) return month1 - month2;
            return day1 - day2;
        });

        System.out.println("Sorted Dates:");
        for (String d : dates) {
            System.out.println(d);
        }
    }
}
