package edu.sjsu.assignment3;
import java.time.LocalDate;

public abstract class Appointment implements Comparable<Appointment>{
    private String description;
    private LocalDate startDate, endDate;

    public Appointment(String description, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean checkBetweenStartEnd(LocalDate date) {
        return ((date.isEqual(startDate) || date.isAfter(startDate))
                && (date.isEqual(endDate) || date.isBefore(endDate)));
    }

    public abstract boolean occursOn(LocalDate date);

    @Override
    public int compareTo(Appointment appointment) {
        if (!startDate.isEqual(appointment.getStartDate())) {
            return startDate.compareTo(appointment.getStartDate());
        } else if (!endDate.isEqual(appointment.getEndDate())) {
            return endDate.compareTo(appointment.getEndDate());
        } else {
            return description.compareTo(appointment.getDescription());
        }
    }
}
