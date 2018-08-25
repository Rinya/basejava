package model;

public class ContactInfo {
    private ContactType contactType;
    private String value;
    private String url;

    ContactInfo(ContactType contactType, String value) {
        this(contactType, value, "");
    }

    ContactInfo(ContactType contactType, String value, String url) {
        this.contactType = contactType;
        this.value = value;
        this.url = url;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUrl() {
        return !"".equals(url);
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "contactType=" + contactType +
                ", value='" + value + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
