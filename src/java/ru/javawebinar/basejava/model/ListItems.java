package ru.javawebinar.basejava.model;

import java.util.List;

public class ListItems<I extends SectionItem> implements SectionItem {
    private List<I> list;

    public ListItems(List<I> list) {
        this.list = list;
    }

    public List<I> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListItems)) return false;

        ListItems<?> listItems = (ListItems<?>) o;

        return getList() != null ? getList().equals(listItems.getList()) : listItems.getList() == null;
    }

    @Override
    public int hashCode() {
        return getList() != null ? getList().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ListItems{" +
                "list=" + list +
                '}';
    }
}
