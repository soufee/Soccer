package model.dao;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Shoma on 27.09.2018.
 */
@Entity
@Table(name = "potentional", schema = "public", catalog = "soccer")
public class PotentionalEntity {
    private int id;
    private Integer potTobeStar;
    private Integer ageToFinish;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pot_tobe_star")
    public Integer getPotTobeStar() {
        return potTobeStar;
    }

    public void setPotTobeStar(Integer potTobeStar) {
        this.potTobeStar = potTobeStar;
    }

    @Basic
    @Column(name = "age_to_finish")
    public Integer getAgeToFinish() {
        return ageToFinish;
    }

    public void setAgeToFinish(Integer ageToFinish) {
        this.ageToFinish = ageToFinish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PotentionalEntity that = (PotentionalEntity) o;
        return id == that.id &&
                Objects.equals(potTobeStar, that.potTobeStar) &&
                Objects.equals(ageToFinish, that.ageToFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, potTobeStar, ageToFinish);
    }
}
