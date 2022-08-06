package az.course.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateChange {


    public static  LocalDate dateToLocal(Date date){
                LocalDate create_date = LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
       return create_date;
    }

    public static Date localToDate(LocalDate localDate){
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);

        // converting ZonedDateTime to Date using Date.from() and ZonedDateTime.toInstant()
        Date utilDate = Date.from(zonedDateTime.toInstant());
        return utilDate;

    }


}
