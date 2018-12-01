package ru.javawebinar.basejava.model;

public enum ContactType {
    PHONE("Тел.", null),
    MOBILE("Мобильный", null),
    HOME_PHONE("Домашний тел.", null),
    SKYPE("Skype", "https://javawebinar.github.io/img/skype.png"),
    EMAIL("Почта", "https://javawebinar.github.io/img/email.png"),
    LINKEDIN("Профиль LinkedIn", "https://javawebinar.github.io/img/lin.png"),
    GITHUB("Профиль GitHub", "https://javawebinar.github.io/img/gh.png"),
    STATCKOVERFLOW("Профиль Stackoverflow", "https://javawebinar.github.io/img/so.png"),
    HOMEPAGE("Домашняя страница", null);

    private String title;
    private String icon;

    ContactType(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public String getIcon() {
        return icon;
    }
}
