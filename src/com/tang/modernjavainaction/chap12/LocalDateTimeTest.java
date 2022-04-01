package com.tang.modernjavainaction.chap12;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Title: LocalDateTimeTest
 * @Description:
 * @author: tangyao
 * @date: 2022/3/22 18:27
 * @Version: 1.0
 */

public class LocalDateTimeTest {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        int year = today.get(ChronoField.YEAR);
        System.out.println("year = " + year);
        int month = today.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("month = " + month);
        int day = today.get(ChronoField.DAY_OF_MONTH);
        System.out.println("day = " + day);

        int year1 = today.getYear();
        System.out.println("year1 = " + year1);
        int monthValue = today.getMonthValue();
        System.out.println("month1 = " + monthValue);
        int dayOfMonth = today.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        LocalTime of = LocalTime.of(12, 45, 54);
        int hour = of.getHour();
        System.out.println("hour = " + hour);
        int minute = of.getMinute();
        System.out.println("minute = " + minute);
        int second = of.getSecond();
        System.out.println("second = " + second);

        LocalDate parse = LocalDate.parse("2020-03-22");
        System.out.println("parse = " + parse);
        LocalTime parse1 = LocalTime.parse("12:43:43");
        System.out.println("parse1 = " + parse1);

        LocalDateTime.of(3432, Month.SEPTEMBER, 21, 13, 45, 20);
        LocalDateTime of1 = LocalDateTime.of(parse, parse1);
        LocalDateTime localDateTime = parse.atTime(13, 34, 32);

        Instant instant = Instant.ofEpochSecond(3);
        System.out.println("instant = " + instant);
        Instant instant1 = Instant.ofEpochSecond(3, 0);
        System.out.println("instant1 = " + instant1);
        Instant instant2 = Instant.ofEpochSecond(2, 1_000_000_000);
        System.out.println("instant2 = " + instant2);
        Instant instant3 = Instant.ofEpochSecond(4, -1_000_000_000);
        System.out.println("instant3 = " + instant3);


        Instant now = Instant.now();
        System.out.println("now = " + now);


        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        LocalDateTime localDateTime1 = now1.plusDays(100).plusSeconds(19);
        now1.plusHours(23);


        Duration between = Duration.between(localDateTime1, now2);
        System.out.println("between = " + between);
        long seconds = between.getSeconds();

        System.out.println("seconds = " + seconds);

        LocalDate of2 = LocalDate.of(2022, 2, 3);
        LocalDate of3 = LocalDate.of(2011, 2, 4);
        Period between1 = Period.between(of2, of3);
        System.out.println("between1 = " + between1);

        LocalTime now3 = LocalTime.now();
        Duration between2 = Duration.between(LocalDateTime.of(of2, now3), LocalDateTime.of(of3, now3));
        System.out.println("between2 = " + between2);


        of2.with(temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            } else if (dayOfWeek == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });

        String format = of1.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("format = " + format);
        String format1 = of1.format(DateTimeFormatter.ISO_DATE);
        System.out.println("format1 = " + format1);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        String format2 = of1.format(dateTimeFormatter);
        System.out.println("format2 = " + format2);

        LocalDateTime parse2 = LocalDateTime.parse(format2, dateTimeFormatter);
        System.out.println("parse2 = " + parse2);

        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println("zoneId = " + zoneId);

        test01();

    }

    public static void test01() {

        ZoneId romeZone = ZoneId.of("Europe/Rome");

        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zonedDateTime = date.atStartOfDay(romeZone);
        System.out.println("zonedDateTime = " + zonedDateTime);
        LocalDateTime dateTime = LocalDateTime.of(2014,Month.MARCH,18,13,45);
        ZonedDateTime zonedDateTime1 = dateTime.atZone(romeZone);
        System.out.println("zonedDateTime1 = " + zonedDateTime1);
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime2 = instant.atZone(romeZone);
        System.out.println("zonedDateTime2 = " + zonedDateTime2);

        Date date1 = new Date();
        Instant instant2 = date1.toInstant();
        System.out.println("instant2 = " + instant2);


        Instant instant1 = dateTime.atZone(romeZone).toInstant();
        Instant now = Instant.now();
        ZonedDateTime zonedDateTime3 = instant.atZone(romeZone);
        System.out.println("zonedDateTime3 = " + zonedDateTime3);

        LocalDateTime dateTime1 = LocalDateTime.ofInstant(instant, romeZone);
        System.out.println("dateTime1 = " + dateTime1);

    }
}