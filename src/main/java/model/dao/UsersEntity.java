package model.dao;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Shoma on 28.09.2018.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "soccer")
public class UsersEntity {
    private int userId;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String role;
    private Timestamp dateOfBirth;
    private Timestamp dateOfRegistration;

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
    @Column(name = "user_name")
    @NaturalId(mutable=true)
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
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

       @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return userId == that.userId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(role, that.role) &&
                               Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, name, email, dateOfBirth, role);
    }

    public boolean hasRole(String userRole){
        return role.contains(userRole);
    }

    @Basic
    @Column(name = "date_of_registration")
    public Timestamp getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Timestamp dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
