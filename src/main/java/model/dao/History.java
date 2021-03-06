package model.dao;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Shoma on 27.09.2018.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history", schema = "public", catalog = "soccer")
public class History implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = false)
    private int id;

    @Column(name = "changes")
    private String changes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "u_id")
    @MapsId
    private Users user;
}
