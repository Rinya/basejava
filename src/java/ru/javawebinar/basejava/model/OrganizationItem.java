package ru.javawebinar.basejava.model;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizationItem implements SectionItem {
    private Link link;
    private List<DurationItem> rowList;

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public List<DurationItem> getRowList() {
        if (rowList == null) {
            rowList = new LinkedList<>();
        }
        return rowList;
    }

    public OrganizationItem withLink(Link link) {
        this.link = link;
        return this;
    }

    public OrganizationItem withRowList(List<DurationItem> list) {
        this.rowList = list;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationItem)) return false;

        OrganizationItem that = (OrganizationItem) o;

        if (getLink() != null ? !getLink().equals(that.getLink()) : that.getLink() != null) return false;
        return getRowList() != null ? getRowList().equals(that.getRowList()) : that.getRowList() == null;
    }

    @Override
    public int hashCode() {
        int result = getLink() != null ? getLink().hashCode() : 0;
        result = 31 * result + (getRowList() != null ? getRowList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return link +
                "\n" +
                rowList
                        .stream()
                        .map(row -> row + "\n")
                        .collect(Collectors.joining());
    }
}
