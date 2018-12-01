package ru.javawebinar.basejava.model;

public class Contact {
    private Link link;
    private String content;

    public Contact(String content) {
        this(content, null);
    }

    public Contact(String content, String url) {
        this.content = content;
        this.link = new Link(content, url);
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Contact withLink(Link link) {
        this.link = link;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        if (getLink() != null ? !getLink().equals(contact.getLink()) : contact.getLink() != null) return false;
        return getContent() != null ? getContent().equals(contact.getContent()) : contact.getContent() == null;
    }

    @Override
    public int hashCode() {
        int result = getLink() != null ? getLink().hashCode() : 0;
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "link=" + link +
                ", content='" + content + '\'' +
                '}';
    }
}
