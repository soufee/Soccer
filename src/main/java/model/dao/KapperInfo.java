package model.dao;

import org.hibernate.annotations.NaturalId;
import lombok.*;
import javax.persistence.*;

/**
 * Created by Shoma on 29.09.2018.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kapper_info", schema = "public", catalog = "soccer")
public class KapperInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = true, updatable = false)
    private int id;

//    @Column(name = "u_id")
//    @NaturalId
//    private int uId;

    @Column(name = "tokens")
    private Double tokens;

    @Column(name = "bets")
    private Integer bets;

    @Column(name = "success_bets")
    private Integer successBets;

    @Column(name = "fail_bets")
    private Integer failBets;

    @Column(name = "blocked_tokens")
    private Double blockedTokens;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "u_id")
    @MapsId
    @NaturalId
    private Users user;

}
