package model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created by Shoma on 29.09.2018.
 */
@Entity
@Table(name = "kapper_info", schema = "public", catalog = "soccer")
public class KapperInfo {
    private int id;
    private Integer userId;
    private BigInteger tokens;
    private Integer bets;
    private Integer successBets;
    private Integer failBets;

    public void setTokens(BigInteger tokens) {
        this.tokens = tokens;
    }

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @NaturalId
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "tokens")
    public BigInteger getTokens() {
        return tokens;
    }

    @Basic
    @Column(name = "bets")
    public Integer getBets() {
        return bets;
    }

    public void setBets(Integer bets) {
        this.bets = bets;
    }

    @Basic
    @Column(name = "success_bets")
    public Integer getSuccessBets() {
        return successBets;
    }

    public void setSuccessBets(Integer successBets) {
        this.successBets = successBets;
    }

    @Basic
    @Column(name = "fail_bets")
    public Integer getFailBets() {
        return failBets;
    }

    public void setFailBets(Integer failBets) {
        this.failBets = failBets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KapperInfo that = (KapperInfo) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(tokens, that.tokens) &&
                Objects.equals(bets, that.bets) &&
                Objects.equals(successBets, that.successBets) &&
                Objects.equals(failBets, that.failBets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, tokens, bets, successBets, failBets);
    }
}
