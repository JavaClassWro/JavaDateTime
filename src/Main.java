import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DECADES;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello DateTime API!");
        Date today = new Date();
        long unixTime = today.getTime();
        System.out.println(unixTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
        System.out.println(format.format(today));
        today.setTime(0);
        System.out.println("Unix Epoch started on "+format.format(today));
        // manipulation
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.YEAR, 1);
        Date newDate = c.getTime();
        System.out.println(format.format(newDate));
        // post Java8
        LocalDateTime today8 = LocalDateTime.now();
        System.out.println(today8);
        // format: yyyy-MM-ddTHH:mm:ss
        LocalDateTime parsed = LocalDateTime.parse("2020-12-01T19:31:59");
        System.out.println("Parsed "+parsed);
        //parsed = parsed.minus(5, DECADES);
        parsed = parsed.minusYears(50);
        System.out.println("Minus 50 years "+parsed);
        // conversion from LocalDateTime parsed to Date
        Date fromLocal = Date.from(parsed.atZone(ZoneId.systemDefault()).toInstant());
        // conversion from Date today to LocalDateTime
        LocalDateTime fromDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
