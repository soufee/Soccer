package model.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Shoma on 27.09.2018.
 */
@Entity
@Table(name = "footbal_player", schema = "public", catalog = "soccer")
public class FootbalPlayerEntity {
    private int id;
    private String firstName;
    private String secondName;
    private Integer teamId;
    private int characteristicsId;
    private int age;
    private String position;
    private Integer potentionalId;
    private Integer historyId;

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = "id", nullable = false, insertable = true, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "team_id")
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "characteristics_id")
    public int getCharacteristicsId() {
        return characteristicsId;
    }

    public void setCharacteristicsId(int characteristicsId) {
        this.characteristicsId = characteristicsId;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "potentional_id")
    public Integer getPotentionalId() {
        return potentionalId;
    }

    public void setPotentionalId(Integer potentionalId) {
        this.potentionalId = potentionalId;
    }

    @Basic
    @Column(name = "history_id")
    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootbalPlayerEntity that = (FootbalPlayerEntity) o;
        return id == that.id &&
                characteristicsId == that.characteristicsId &&
                age == that.age &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(teamId, that.teamId) &&
                Objects.equals(position, that.position) &&
                Objects.equals(potentionalId, that.potentionalId) &&
                Objects.equals(historyId, that.historyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, teamId, characteristicsId, age, position, potentionalId, historyId);
    }
}
