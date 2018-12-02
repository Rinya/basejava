package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static ru.javawebinar.basejava.model.ContactType.*;
import static ru.javawebinar.basejava.model.SectionType.*;

public class ResumeTestData {
    public static Resume resume;

    public static void main(String[] args) {
        resume = new Resume("Григорий Кислин");
        createContact(PHONE, "+7(921) 855-0482");
        createContact(SKYPE, "grigory.kislin");
        createContact(EMAIL, "gkislin@yandex.ru");
        createContact(LINKEDIN, "Профиль LinkedIn");
        createContact(GITHUB, "Профиль GitHub");
        createContact(STATCKOVERFLOW, "Профиль Stackoverflow");
        createContact(HOMEPAGE, "Домашняя страница");

        SimpleItem objectiveItem = new SimpleItem("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        createSection(OBJECTIVE, objectiveItem);

        SimpleItem personalItem = new SimpleItem("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        createSection(PERSONAL, personalItem);

        List<SimpleItem> achievementList = new LinkedList<>();
        achievementList.add(new SimpleItem("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников."));
        achievementList.add(new SimpleItem("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."));
        achievementList.add(new SimpleItem("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера."));
        achievementList.add(new SimpleItem("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга."));
        achievementList.add(new SimpleItem("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django)."));
        achievementList.add(new SimpleItem("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));
        createListOfSimpleItemSection(ACHIEVEMENT, achievementList);

        List<SimpleItem> qualificationList = new LinkedList<>();
        qualificationList.add(new SimpleItem("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2"));
        qualificationList.add(new SimpleItem("Version control: Subversion, Git, Mercury, ClearCase, Perforce"));
        qualificationList.add(new SimpleItem("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,"));
        qualificationList.add(new SimpleItem("MySQL, SQLite, MS SQL, HSQLDB"));
        qualificationList.add(new SimpleItem("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,"));
        qualificationList.add(new SimpleItem("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,"));
        qualificationList.add(new SimpleItem("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements)."));
        qualificationList.add(new SimpleItem("Python: Django."));
        qualificationList.add(new SimpleItem("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js"));
        qualificationList.add(new SimpleItem("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka"));
        qualificationList.add(new SimpleItem("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT."));
        qualificationList.add(new SimpleItem("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,"));
        qualificationList.add(new SimpleItem("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer."));
        qualificationList.add(new SimpleItem("Отличное знание и опыт применения концепций ООП, SOA, шаблонов"));
        qualificationList.add(new SimpleItem("проектрирования, архитектурных шаблонов, UML, функционального"));
        qualificationList.add(new SimpleItem("программирования"));
        qualificationList.add(new SimpleItem("Родной русский, английский \"upper intermediate\""));
        createListOfSimpleItemSection(QUALIFICATIONS, qualificationList);

        LinkedList<OrganizationItem> expirienceList = new LinkedList<>();
        expirienceList.add(createOrganizationItem("Java Online Projects",
                                                    "http://javaops.ru/",
                                                    LocalDate.of(2013, 10, 1),
                                                    null,
                                                    "Автор проекта.",
                                                    "Создание, организация и проведение Java онлайн проектов и стажировок."
                                                    ));

        expirienceList.add(createOrganizationItem("Wrike",
                                                    "https://www.wrike.com/",
                                                    LocalDate.of(2014, 10, 1),
                                                    LocalDate.of(2016, 1, 1),
                                                    "Старший разработчик (backend)",
                                                    "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."
                                                    ));

        expirienceList.add(createOrganizationItem("RIT Center",
                null,
                LocalDate.of(2012, 4, 1),
                LocalDate.of(2014, 10, 1),
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"
        ));

        expirienceList.add(createOrganizationItem("Luxoft (Deutsche Bank)",
                "http://www.luxoft.ru/",
                LocalDate.of(2010, 12, 1),
                LocalDate.of(2012, 4, 1),
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."
        ));

        expirienceList.add(createOrganizationItem("Yota",
                "https://www.yota.ru/",
                LocalDate.of(2008, 6, 1),
                LocalDate.of(2010, 12, 1),
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"
        ));

        expirienceList.add(createOrganizationItem("Enkata",
                "http://enkata.com/",
                LocalDate.of(2007, 3, 1),
                LocalDate.of(2008, 6, 1),
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."
        ));

        expirienceList.add(createOrganizationItem("Siemens AG",
                "https://www.siemens.com/ru/ru/home.html",
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2007, 3, 1),
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."
        ));

        expirienceList.add(createOrganizationItem("Alcatel",
                "http://www.alcatel.ru/",
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."
        ));
        createListOfOrganizationItemSection(EXPERIENCE, expirienceList);

        LinkedList<OrganizationItem> educationList = new LinkedList<>();
        educationList.add(createOrganizationItem("Coursera",
                "https://www.coursera.org/course/progfun",
                LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1),
                "\"Functional Programming Principles in Scala\" by Martin Odersky"));

        educationList.add(createOrganizationItem("Luxoft",
                "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366",
                LocalDate.of(2011, 3, 1),
                LocalDate.of(2011, 4, 1),
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\""));

        educationList.add(createOrganizationItem("Siemens AG",
                "http://www.siemens.ru/",
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 4, 1),
                "3 месяца обучения мобильным IN сетям (Берлин)"));

        educationList.add(createOrganizationItem("Alcatel",
                "http://www.alcatel.ru/",
                LocalDate.of(1997, 9, 1),
                LocalDate.of(1998, 3, 1),
                "6 месяцев обучения цифровым телефонным сетям (Москва)"));

        OrganizationItem item = new OrganizationItem()
                .withLink(new Link("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                        "http://www.ifmo.ru/"));
        DurationItem durationItem = new DurationItem()
                        .withBegin(LocalDate.of(1993, 9, 1))
                        .withEnd(LocalDate.of(1996, 7, 1))
                        .withTitle("Аспирантура (программист С, С++)");
        item.getRowList().add(durationItem);

        durationItem = new DurationItem()
                        .withBegin(LocalDate.of(1987, 9, 1))
                        .withEnd(LocalDate.of(1993, 7, 1))
                        .withTitle("Инженер (программист Fortran, C)");
        item.getRowList().add(durationItem);
        educationList.add(item);

        educationList.add(createOrganizationItem("Заочная физико-техническая школа при МФТИ",
                "http://www.school.mipt.ru/",
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "Закончил с отличием"));

        createListOfOrganizationItemSection(EDUCATION, educationList);

        showResume(resume);
    }

    private static OrganizationItem createOrganizationItem(String organization, String url,
                                                           LocalDate beginDate, LocalDate endDate, String title) {
        return createOrganizationItem(organization, url, beginDate, endDate, title, null);
    }

    private static OrganizationItem createOrganizationItem(String organization, String url,
                                                           LocalDate beginDate, LocalDate endDate, String title,
                                                           String description) {
        OrganizationItem item = new OrganizationItem()
                .withLink(new Link(organization, url));

        DurationItem durationItem = new DurationItem()
                .withBegin(beginDate)
                .withEnd(endDate)
                .withTitle(title)
                .withDescription(description);
        item.getRowList().add(durationItem);
        return item;
    }

    private static Section createListOfOrganizationItemSection(SectionType type, List<OrganizationItem> list) {
        ListItems<OrganizationItem> listItems = new ListItems<>(list);
        Section<ListItems<OrganizationItem>> section = new Section<>(listItems);
        return resume.getSections().put(type, section);
    }

    private static Section createListOfSimpleItemSection(SectionType type, List<SimpleItem> list) {
        ListItems<SimpleItem> listItems = new ListItems<>(list);
        Section<ListItems<SimpleItem>> section = new Section<>(listItems);
        return resume.getSections().put(type, section);
    }

    private static Section createSection(SectionType type, SectionItem item) {
        Section<SectionItem> section = new Section<>(item);
        return resume.getSections().put(type, section);
    }

    private static void showResume(Resume resume) {
        System.out.println(resume.getFullname());
        resume
                .getContacts()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey().getTitle() + ": "
                    + entry.getValue())
                .forEach(System.out::println);

        for (Map.Entry<SectionType, Section> entry: resume.getSections().entrySet()) {
            System.out.println(entry.getKey().getTitle());
            SectionItem sectionItem = entry.getValue().getItem();
            if (sectionItem instanceof SimpleItem) {
                System.out.println(((SimpleItem) sectionItem).getDescription());
            } else if (sectionItem instanceof ListItems) {
                for (SectionItem item: ((ListItems<SectionItem>) sectionItem).getList()) {
                    System.out.println(item);
                }
            }
            System.out.println();
        }
    }

    private static void createContact(ContactType type, String contact) {
        resume
                .getContacts()
                .put(type, contact);
    }
}
