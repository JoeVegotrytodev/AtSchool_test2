package mod2les25;

import java.text.DateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import static java.time.format.DateTimeFormatter.ISO_ORDINAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE;
import static java.time.format.DateTimeFormatter.ISO_OFFSET_TIME;
import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class FirstTask {

    public static void main(String[] args) {
        Date startDate = new Date();

        System.out.println("--- Class Date ---");

        //3. Заменил 00 на 0  в датах
        Date birthDayDate = new Date(98, Calendar.AUGUST, 4, 0, 0, 0);
        System.out.println("Первый вывод: " + birthDayDate);
        //System.out.println("Первый вывод: " + new Date(98, Calendar.AUGUST, 4,0,0,0));
        Date endClassDateExe = new Date();

        //1. изменил pattern - строка 38 закомментирована
        //2. изменил sout - пробежался по коду, вроде в остальных местах созданные объекты используются далее несколько
        // раз, в таких случаях удобнее создавать переменную
        //String pattern = "yyyy-MM-dd 'T'HH:mm:ss.SSSZ";
        //String birthDate = new SimpleDateFormat(pattern).format(birthDayDate);
        System.out.println("Второй вывод: " + new SimpleDateFormat("yyyy-MM-dd 'T'HH:mm:ss.SSSZ").format(birthDayDate));
        System.out.println("Третий вывод: " + new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSSz").format(birthDayDate));
        System.out.println("Четвертый вывод: " + new SimpleDateFormat("G YYYY ww DDD").format(birthDayDate));
        System.out.println("Пятый вывод: " + new SimpleDateFormat("E_u_a_k_X").format(birthDayDate) + "\n");


        Date localDateStart = new Date();
        System.out.println("--- Class LocalDate ---");
        LocalDate birthDayLocalDate = LocalDate.of(1998,8,4);
        System.out.println("Первый вывод: " + birthDayLocalDate);
        //System.out.println("Первый вывод: " + LocalDate.of(1998,8,4));

        System.out.println("Второй вывод: " + birthDayLocalDate.getMonthValue() + "/"
                + birthDayLocalDate.getDayOfMonth() + "/" + birthDayLocalDate.getEra());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("G yyyy MM dd");

        System.out.println("Третий вывод: " + birthDayLocalDate.format(format));

        format = DateTimeFormatter.ofPattern("L Q");//месяц и какая четверть года
        System.out.println("Четвертый вывод: " + birthDayLocalDate.format(format));

        System.out.println("Пятый вывод: " + birthDayLocalDate.format(ISO_ORDINAL_DATE) + "\n");
        Date localDateEnd = new Date();


        Date localDateTimeStart = new Date();
        System.out.println("--- Class LocalDateTime ---");
        LocalDateTime birthDayLocalDateTime = LocalDateTime.of(1998,8,4,12,12,12);
        System.out.println("Первый вывод: " + birthDayLocalDateTime);
        System.out.println("Второй вывод: " + birthDayLocalDateTime.format(ISO_DATE));
        System.out.println("Третий вывод: " + birthDayLocalDateTime.format(ISO_LOCAL_TIME));
        System.out.println("Четвертый вывод: " + birthDayLocalDateTime.format(ISO_LOCAL_DATE_TIME));
        System.out.println("Пятый вывод: " + birthDayLocalDateTime.format(BASIC_ISO_DATE) + "\n");
        Date localDateTimeEnd = new Date();

        Date zonedDateTimeStart = new Date();
        System.out.println("--- Class ZonedDateTime ---");
        ZoneId zoneId = ZoneId.of("UTC+4");
        ZonedDateTime birthDayZoned = ZonedDateTime.of(1998, 8, 4, 12,12,12,12, zoneId);
        System.out.println("Первый вывод: " + birthDayZoned);
        //хоть и указал zoneID но при поптыке использовать ISO_OFFSET_DATE или ISO_OFFSET_TIME
        //ошибка была  Unsupported field: OffsetSeconds - почему ?
        System.out.println("Второй вывод: " + birthDayLocalDateTime.format(ISO_DATE));
        System.out.println("Третий вывод: " + birthDayLocalDateTime.format(ISO_LOCAL_TIME));
        System.out.println("Четвертый вывод: " + birthDayLocalDateTime.format(ISO_LOCAL_DATE_TIME));
        System.out.println("Пятый вывод: " + birthDayLocalDateTime.format(BASIC_ISO_DATE) + "\n");
        Date zonedDateTimeEnd = new Date();

        Date gregorianCalendarStart = new Date();
        System.out.println("--- Class GregorianCalendar ---");
        GregorianCalendar birthDayGregorian = new GregorianCalendar(1998, 8, 4, 12, 12,12);
        System.out.println("Первый вывод: " + birthDayGregorian.get(Calendar.MONTH) + ", " + birthDayGregorian.get(Calendar.DAY_OF_WEEK));
        System.out.println("Второй вывод: " + (birthDayGregorian.get(Calendar.ZONE_OFFSET)/(60*60*1000)));//часовой пояс в часах
        System.out.println("Третий вывод: " + birthDayGregorian.get(Calendar.DAY_OF_WEEK) + ", " + birthDayGregorian.get(Calendar.DAY_OF_MONTH)
                + ", " + birthDayGregorian.get(Calendar.DAY_OF_YEAR) + ", " + birthDayGregorian.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("Четвертый вывод: " + birthDayGregorian.get(Calendar.AM_PM) + ", " + birthDayGregorian.get(Calendar.HOUR) +
                ", " + birthDayGregorian.get(Calendar.HOUR)  + ", " + birthDayGregorian.get(Calendar.HOUR_OF_DAY));
        System.out.println("Пятый вывод: " + birthDayGregorian.get(Calendar.MINUTE) + ", " + birthDayGregorian.get(Calendar.SECOND) +
                ", " +  birthDayGregorian.get(Calendar.MILLISECOND));

        Date stopDate = new Date();

        System.out.println("\n\n--- Task 2 ---");
        Date currentDate = new Date();
        //тип к которому приводим результат
        TimeUnit timeUnit = TimeUnit.DAYS;
        //находим разницу в миллисекундах
        long differenceInMillies = currentDate.getTime() - birthDayDate.getTime();
        System.out.println("Сравнение дат класса Date: " + currentDate.compareTo(birthDayDate) + "\n" +
                "Разница между датами " + timeUnit.convert(differenceInMillies,TimeUnit.MILLISECONDS) + " дня." + "\n");

        LocalDate currentLocalDate = LocalDate.now();
        //compareTo - the comparator value, negative if less, positive if greater
        System.out.println("Сравнение дат класса LocalDate: " + currentLocalDate.compareTo(birthDayLocalDate) + "\n" +
                "Разница между датами " + ChronoUnit.DAYS.between(birthDayLocalDate, currentLocalDate) + " дня." + "\n");

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        System.out.println("Сравнение дат класса LocalDateTime: " + currentLocalDate.compareTo(birthDayLocalDate) + "\n" +
                "Разница между датами " + ChronoUnit.DAYS.between(birthDayLocalDateTime, currentLocalDateTime) + " дня." + "\n");

        ZonedDateTime currentDateZoned = ZonedDateTime.now();
        System.out.println("Сравнение дат класса ZonedDateTime: " + currentLocalDate.compareTo(birthDayLocalDate) + "\n" +
                "Разница между датами " + ChronoUnit.DAYS.between(birthDayZoned, currentDateZoned) + " дня." + "\n");

        GregorianCalendar currentDateGregorian = new GregorianCalendar();
        differenceInMillies = currentDateGregorian.getTimeInMillis() - birthDayGregorian.getTimeInMillis();
        System.out.println("Сравнение дат класса GregorianCalendar: " + currentDateGregorian.compareTo(birthDayGregorian) + "\n" +
                "Разница между датами " + timeUnit.convert(differenceInMillies,TimeUnit.MILLISECONDS) + " дня.");
        //почему тут вывод неточный в сравнений с другими способами ?


        System.out.println("\n\n--- Task 3 ---");
        differenceInMillies = stopDate.getTime() - startDate.getTime();
        System.out.println("Время выполнения первого задания: " + differenceInMillies + " миллисекунд.");

        System.out.println("\n\n--- Task 4 ---");
        differenceInMillies = endClassDateExe.getTime() - startDate.getTime();
        System.out.println("Время выполнения класса Date первого задания: " + differenceInMillies + " миллисекунд.");
        differenceInMillies = localDateEnd.getTime() - localDateStart.getTime();
        System.out.println("Время выполнения класса LocalDate первого задания: " + differenceInMillies + " миллисекунд.");
        differenceInMillies = localDateTimeEnd.getTime() - localDateTimeStart.getTime();
        System.out.println("Время выполнения класса LocalDateTime первого задания: " + differenceInMillies + " миллисекунд.");
        differenceInMillies = zonedDateTimeEnd.getTime() - zonedDateTimeStart.getTime();
        System.out.println("Время выполнения класса ZonedDateTime первого задания: " + differenceInMillies + " миллисекунд.");
        differenceInMillies = stopDate.getTime() - gregorianCalendarStart.getTime();
        System.out.println("Время выполнения класса GregorianCalendar первого задания: " + differenceInMillies + " миллисекунд.");
    }
}
