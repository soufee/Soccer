package model.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Shoma on 27.09.2018.
 */
@Entity
@Table(name = "characteristics", schema = "public", catalog = "soccer")
public class CharacteristicsEntity {
    private int id;
    private Integer speed;
    private Integer strength;
    private String majorFoot;
    private Integer pickSkills;
    private Integer kickPower;
    private Integer kickAccuracy;
    private Integer passAccuracy;

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
    @Column(name = "speed")
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "strength")
    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Basic
    @Column(name = "major_foot")
    public String getMajorFoot() {
        return majorFoot;
    }

    public void setMajorFoot(String majorFoot) {
        this.majorFoot = majorFoot;
    }

    @Basic
    @Column(name = "pick_skills")
    public Integer getPickSkills() {
        return pickSkills;
    }

    public void setPickSkills(Integer pickSkills) {
        this.pickSkills = pickSkills;
    }

    @Basic
    @Column(name = "kick_power")
    public Integer getKickPower() {
        return kickPower;
    }

    public void setKickPower(Integer kickPower) {
        this.kickPower = kickPower;
    }

    @Basic
    @Column(name = "kick_accuracy")
    public Integer getKickAccuracy() {
        return kickAccuracy;
    }

    public void setKickAccuracy(Integer kickAccuracy) {
        this.kickAccuracy = kickAccuracy;
    }

    @Basic
    @Column(name = "pass_accuracy")
    public Integer getPassAccuracy() {
        return passAccuracy;
    }

    public void setPassAccuracy(Integer passAccuracy) {
        this.passAccuracy = passAccuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacteristicsEntity that = (CharacteristicsEntity) o;
        return id == that.id &&
                Objects.equals(speed, that.speed) &&
                Objects.equals(strength, that.strength) &&
                Objects.equals(majorFoot, that.majorFoot) &&
                Objects.equals(pickSkills, that.pickSkills) &&
                Objects.equals(kickPower, that.kickPower) &&
                Objects.equals(kickAccuracy, that.kickAccuracy) &&
                Objects.equals(passAccuracy, that.passAccuracy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speed, strength, majorFoot, pickSkills, kickPower, kickAccuracy, passAccuracy);
    }
}
