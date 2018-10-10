package model.dao;

import lombok.*;
import lombok.extern.log4j.Log4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;
@Log4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personal_info", schema = "public", catalog = "soccer")
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = false)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "u_id")
    @MapsId
    private Users user;
    /**
     * текстовое представление аватарки в Base64
     * */
    @Column(name = "photo")
    private String photo;

    @Column(name = "about")

    private String about;

}
