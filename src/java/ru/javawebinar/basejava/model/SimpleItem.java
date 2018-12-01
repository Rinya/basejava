package ru.javawebinar.basejava.model;

public class SimpleItem implements SectionItem {
    private String description;

    public SimpleItem() {
    }

    public SimpleItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleItem)) return false;

        SimpleItem that = (SimpleItem) o;

        return getDescription() != null ? getDescription().equals(that.getDescription()) : that.getDescription() == null;
    }

    @Override
    public int hashCode() {
        return getDescription() != null ? getDescription().hashCode() : 0;
    }

    @Override
    public String toString() {
        return description;
    }
}
