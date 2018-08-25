package model;

public enum ContactType {
    PHONE("Тел.: ", "", null),
    SKYPE("Skype: ", "/skype.png", 1),
    EMAIL("Почта: ", "/email.png", 1),
    LINKEDIN_PROFILE("", "/linkedin.png", 0),
    GITHUB_PROFILE("", "/github.png", 0),
    STACKOVERFLOW_PROFILE("", "/stackov.png", 0),
    HOMEPAGE("", "", null);

    private String name;
    private String iconPath;
    private Integer align;

    ContactType(String name, String iconPath, Integer align) {
        this.name = name;
        this.iconPath = iconPath;
        this.align = align;
    }

    public String getName() {
        return name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public Integer getAlign() {
        return align;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "name='" + name + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", align=" + align +
                '}';
    }
}
