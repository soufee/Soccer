package model.dao;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Shoma on 27.09.2018.
 */
@Entity
@Table(name = "league", schema = "public", catalog = "soccer")
public class LeagueEntity {
    private int id;
    private int countryId;
    private Integer teamCapacity;
    private String nameOfLeague;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country_id")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "team_capacity")
    public Integer getTeamCapacity() {
        return teamCapacity;
    }

    public void setTeamCapacity(Integer teamCapacity) {
        this.teamCapacity = teamCapacity;
    }

    @Basic
    @Column(name = "name_of_league")
    public String getNameOfLeague() {
        return nameOfLeague;
    }

    public void setNameOfLeague(String nameOfLeague) {
        this.nameOfLeague = nameOfLeague;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeagueEntity that = (LeagueEntity) o;
        return id == that.id &&
                countryId == that.countryId &&
                Objects.equals(teamCapacity, that.teamCapacity) &&
                Objects.equals(nameOfLeague, that.nameOfLeague);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryId, teamCapacity, nameOfLeague);
    }
}
