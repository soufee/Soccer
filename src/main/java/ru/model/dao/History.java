package ru.model.dao;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
