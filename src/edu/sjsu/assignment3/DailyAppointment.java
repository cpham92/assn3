package edu.sjsu.assignment3;
import java.time.LocalDate;

public class DailyAppointment extends Appointment{
    public DailyAppointment(String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    @Override
    public boolean occursOn(LocalDate date) {
        return checkBetweenStartEnd(date);
    }
}
