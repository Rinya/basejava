package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DurationItem extends SimpleItem {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/YYYY");
    private LocalDate begin;
    private LocalDate end;
    private String title;

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DurationItem withBegin(LocalDate begin) {
        this.setBegin(begin);
        return  this;
    }

    public DurationItem withEnd(LocalDate end) {
        this.setEnd(end);
        return  this;
    }

    public DurationItem withTitle(String title) {
        this.setTitle(title);
        return  this;
    }

    public DurationItem withDescription(String description) {
        this.setDescription(description);
        return  this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DurationItem)) return false;
        if (!super.equals(o)) return false;

        DurationItem that = (DurationItem) o;

        if (getBegin() != null ? !getBegin().equals(that.getBegin()) : that.getBegin() != null) return false;
        if (getEnd() != null ? !getEnd().equals(that.getEnd()) : that.getEnd() != null) return false;
        return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getBegin() != null ? getBegin().hashCode() : 0);
        result = 31 * result + (getEnd() != null ? getEnd().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return begin.format(FORMATTER) + " - " + (end != null? end.format(FORMATTER) : "Сейчас") +
                " " + title +
                "\n" +
                (getDescription() != null? getDescription() : "");
    }
}
