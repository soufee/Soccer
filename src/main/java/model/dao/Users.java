package model.dao;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Users {
    private int userId;
    private String userName;
    private String password;
    private String name;
    private String email;
    private Timestamp dateOfBirth;
    private Timestamp dateOfRegistration;
    private int roleId;
    private Boolean isblocked;
    private String currency;
    private String lang;

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = "user_id", nullable = false, insertable = true, updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @NaturalId
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @NaturalId
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "role_id")
    public int getRole() {
        return roleId;
    }

    public void setRole(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "date_of_registration")
    public Timestamp getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Timestamp dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return userId == users.userId &&
                roleId == users.roleId &&
                Objects.equals(userName, users.userName) &&
                Objects.equals(password, users.password) &&
                Objects.equals(name, users.name) &&
                Objects.equals(email, users.email) &&
                Objects.equals(dateOfBirth, users.dateOfBirth) &&
                Objects.equals(dateOfRegistration, users.dateOfRegistration) &&
                Objects.equals(isblocked, users.isblocked) &&
                Objects.equals(currency, users.currency) &&
                Objects.equals(lang, users.lang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, name, email, dateOfBirth, dateOfRegistration, roleId, isblocked, currency, lang);
    }

    @Basic
    @Column(name = "isblocked")
    public Boolean getIsblocked() {
        return isblocked;
    }

    public void setIsblocked(Boolean isblocked) {
        this.isblocked = isblocked;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "lang")
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean hasRole(int role_id){
        return getRole()==role_id;
    }
}
