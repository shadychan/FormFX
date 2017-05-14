package entity;

import org.yorichan.formfx.annotation.FieldId;
import java.util.Date;
import java.util.List;

/**
 * Created by YoriChan on 2017/4/25
 * This is user entity class
 */
public class User {

    @FieldId("#username")       // use @FieldId to map the form field
    private String username;

    @FieldId("#pwd")
    private String pwd;

    @FieldId("#gender")
    private String gender;

    @FieldId("#bir")
    private Date birthday;

    @FieldId("#hobby")
    private List<String> hobby;

    @FieldId("#job")
    private String job;

    @FieldId("#about")
    private String about;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", hobby=" + hobby +
                ", job='" + job + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

}
