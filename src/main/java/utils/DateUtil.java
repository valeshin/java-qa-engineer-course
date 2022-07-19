package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DateUtil {

    /**
     * Метод парсинга даты начала курса
     * учитывает отображение уже стартовавших курсов
     * добавлена подстраховки при сравнении дат в конце года
     *
     * @param startDate дата начала курса
     * @return date дата начала курса преобразованная в LocalDate
     */
    public static LocalDate parseStartDate(String startDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));
        LocalDate date = LocalDate.parse(startDate + " " + LocalDate.now().getYear(), dtf);
        return date.compareTo(LocalDate.now().minusMonths(1)) >= 0 ? date : date.plusYears(1);
    }

    /**
     * Метод сравнения дат начала курсов
     * в случае равенства возвращается рандомный boolean для рандомизации выбора курса
     *
     * @param startDate1 дата начала первого сравниваемого курса
     * @param startDate2 дата начала второго сравниваемого курса
     * @return boolean
     */
    public static boolean compareCourseDate(String startDate1, String startDate2) {
        LocalDate date1 = parseStartDate(startDate1);
        LocalDate date2 = parseStartDate(startDate2);

        if (date1.isAfter(date2)) {
            return true;
        } else if (date1.isBefore(date2)) {
            return false;
        } else {
            return ThreadLocalRandom.current().nextBoolean();
        }
    }
}
