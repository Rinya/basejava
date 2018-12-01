package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Period {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/YYYY");
    private LocalDate begin;
    private LocalDate end;

    public Period(LocalDate begin, LocalDate end) {
        this.begin = begin;
        this.end = end;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Period)) return false;

        Period period = (Period) o;

        if (getBegin() != null ? !getBegin().equals(period.getBegin()) : period.getBegin() != null) return false;
        return getEnd() != null ? getEnd().equals(period.getEnd()) : period.getEnd() == null;
    }

    @Override
    public int hashCode() {
        int result = getBegin() != null ? getBegin().hashCode() : 0;
        result = 31 * result + (getEnd() != null ? getEnd().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return begin.format(FORMATTER) +
                " - " + (end != null? end.format(FORMATTER) : "Сейчас");
    }
}
