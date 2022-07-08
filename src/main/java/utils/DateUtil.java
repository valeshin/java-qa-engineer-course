package utils;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DateUtil {

    public static ArrayList<String> getMonthsArray() {
        Month previousMonth = LocalDateTime.now().getMonth().minus(1);
        ArrayList<String> months = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            months.add(previousMonth.getDisplayName(TextStyle.FULL, new Locale("ru")));
            previousMonth = previousMonth.plus(1);
        }
        return months;
    }

    public static boolean compareCourseDate(String date1, String date2) {
        int day1 = Integer.parseInt(date1.split(" ")[0]);
        String month1 = date1.split(" ")[1];

        int day2 = Integer.parseInt(date2.split(" ")[0]);
        String month2 = date2.split(" ")[1];

        ArrayList<String> months = getMonthsArray();

        if (months.indexOf(month1) > months.indexOf(month2)) {
            return true;
        } else if (months.indexOf(month1) < months.indexOf(month2)) {
            return false;
        } else if (day1 > day2) {
            return true;
        } else if (day1 < day2) {
            return false;
        } else {
            return ThreadLocalRandom.current().nextBoolean();
        }
    }
}
