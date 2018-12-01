package ru.javawebinar.basejava.model;

public class Section<I extends SectionItem> {
    private I item;

    public Section(I item) {
        this.item = item;
    }

    public I getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;

        Section<?> section = (Section<?>) o;

        return getItem() != null ? getItem().equals(section.getItem()) : section.getItem() == null;
    }

    @Override
    public int hashCode() {
        return getItem() != null ? getItem().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Section{" +
                "item=" + item +
                '}';
    }
}
