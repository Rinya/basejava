package ru.javawebinar.basejava.model;

public class DurationItem extends SimpleItem {
    private Period duration;
    private String title;

    public Period getDuration() {
        return duration;
    }

    public void setDuration(Period duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DurationItem withDuration(Period period) {
        this.setDuration(period);
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

        //TODO check, will the method be called
        if (getDuration() != null ? !getDuration().equals(that.getDuration()) : that.getDuration() != null)
            return false;
        return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return duration +
                " " + title +
                "\n" +
                (getDescription() != null? getDescription() : "");
    }
}
