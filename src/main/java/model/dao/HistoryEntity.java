package model.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Shoma on 27.09.2018.
 */
@Entity
@Table(name = "history", schema = "public", catalog = "soccer")
public class HistoryEntity {
    private int id;
    private Integer playerId;
    private String changes;

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
    @Column(name = "player_id")
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    @Basic
    @Column(name = "changes")
    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEntity that = (HistoryEntity) o;
        return id == that.id &&
                Objects.equals(playerId, that.playerId) &&
                Objects.equals(changes, that.changes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerId, changes);
    }
}
