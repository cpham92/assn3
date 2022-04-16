package edu.sjsu.assignment3;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.parse("2022-01-27");
        LocalDate endDate = LocalDate.parse("2022-05-18");

        LocalDate testDate1 = LocalDate.parse("2022-01-27");
        LocalDate testDate2 = LocalDate.parse("2022-03-18");
        LocalDate testDate3 = LocalDate.parse("2022-05-27");

        Appointment appointment1 = new OnetimeAppointment("Class starts", startDate);
        System.out.println(appointment1.occursOn(testDate1)); // returns true
        System.out.println(appointment1.occursOn(testDate2)); // returns false (not the same date)
        System.out.println(appointment1.occursOn(testDate3) + "\n"); // returns false (not the same date)


        Appointment appointment2 = new DailyAppointment("Class", startDate, endDate);
        System.out.println(appointment2.occursOn(testDate1)); // returns true
        System.out.println(appointment2.occursOn(testDate2)); // returns true
        System.out.println(appointment2.occursOn(testDate3) + "\n"); // returns false (after the end date)

        Appointment appointment3 = new MonthlyAppointment("Meeting", startDate, endDate);
        System.out.println(appointment3.occursOn(testDate1)); // returns true
        System.out.println(appointment3.occursOn(testDate2)); // returns false (day of month not same)
        System.out.println(appointment3.occursOn(testDate3) + "\n"); // returns false (after the end date)

        Appointment a1 = new OnetimeAppointment("Class starts", LocalDate.parse("2022-01-27"));
        Appointment a2 = new DailyAppointment("Class", LocalDate.parse("2022-01-27"), LocalDate.parse("2022-05-18"));
        Appointment a3 = new DailyAppointment("Assignments", LocalDate.parse("2022-02-16"), LocalDate.parse("2022-05-16"));
        Appointment a4 = new MonthlyAppointment("A meeting", LocalDate.parse("2022-01-27"), LocalDate.parse("2022-05-18"));
        Appointment a5 = new MonthlyAppointment("A meeting", LocalDate.parse("2022-02-16"), LocalDate.parse("2022-05-18"));
        Appointment[] appts = {a1, a2, a3, a4, a5};
        System.out.println(Arrays.toString(appts));
        Arrays.sort(appts); // result order : a1, a4, a2, a3, a5
        System.out.println(Arrays.toString(appts));
        Arrays.sort(appts, new DesComparator());
        System.out.println(Arrays.toString(appts)); // result order: a4, a5, a3, a2, a1
    }
}
