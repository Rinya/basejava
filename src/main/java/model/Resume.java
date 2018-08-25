package model;

import utils.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Resume {
    private UUID uuid;
    private String lastName;
    private String firstName;
    private String middleName;
    private List<ContactInfo> contactList;
    private String position;
    private String softSkill;
    private List<Progress> progressList;
    private List<HardSkill> hardSkillList;
    private List<Experience> experienceList;
    private List<Education> educationList;

    public Resume(String lastName, String firstName, String middleName) {
        this.uuid = UUID.randomUUID();
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public List<ContactInfo> getContactList() {
        return contactList;
    }

    public void setContactList(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSoftSkill() {
        return softSkill;
    }

    public void setSoftSkill(String softSkill) {
        this.softSkill = softSkill;
    }

    public List<Progress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<Progress> progressList) {
        this.progressList = progressList;
    }

    public List<HardSkill> getHardSkillList() {
        return hardSkillList;
    }

    public void setHardSkillList(List<HardSkill> hardSkillList) {
        this.hardSkillList = hardSkillList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public String getFullName() {
        StringBuffer buffer = new StringBuffer();
        if (StringUtils.isNotEmpty(lastName)) {
            buffer.append(lastName);
        }

        if (StringUtils.isNotEmpty(firstName)) {
            if (buffer.length() != 0) {
                buffer.append(" ");
            }
            buffer.append(firstName);
        }

        if (StringUtils.isNotEmpty(middleName)) {
            if (buffer.length() != 0) {
                buffer.append(" ");
            }
            buffer.append(middleName);
        }

        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;
        Resume resume = (Resume) o;
        return Objects.equals(getUuid(), resume.getUuid()) &&
                Objects.equals(getLastName(), resume.getLastName()) &&
                Objects.equals(getFirstName(), resume.getFirstName()) &&
                Objects.equals(getMiddleName(), resume.getMiddleName()) &&
                Objects.equals(getContactList(), resume.getContactList()) &&
                Objects.equals(getPosition(), resume.getPosition()) &&
                Objects.equals(getSoftSkill(), resume.getSoftSkill()) &&
                Objects.equals(getProgressList(), resume.getProgressList()) &&
                Objects.equals(getHardSkillList(), resume.getHardSkillList()) &&
                Objects.equals(getExperienceList(), resume.getExperienceList()) &&
                Objects.equals(getEducationList(), resume.getEducationList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getLastName(), getFirstName(), getMiddleName(), getContactList(), getPosition(), getSoftSkill(), getProgressList(), getHardSkillList(), getExperienceList(), getEducationList());
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uuid=" + uuid +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", contactList=" + contactList +
                ", position='" + position + '\'' +
                ", softSkill='" + softSkill + '\'' +
                ", progressList=" + progressList +
                ", hardSkillList=" + hardSkillList +
                ", experienceList=" + experienceList +
                ", educationList=" + educationList +
                '}';
    }
}
