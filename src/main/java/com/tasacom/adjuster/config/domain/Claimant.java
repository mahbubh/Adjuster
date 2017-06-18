package com.tasacom.iadjuster.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Claimant.
 */
@Entity
@Table(name = "claimant")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="claimant_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="claimantType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClaimantProperty.class, name = "property"),
        @JsonSubTypes.Type(value = ClaimantVehicle.class, name = "vehicle")
})
public abstract class Claimant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "date_of_loss")
    protected ZonedDateTime dateOfLoss;

    @Column(name = "facts_of_loss")
    protected String factsOfLoss;

    @Column(name = "comments")
    protected String comments;

    @ManyToOne
    protected Claim claim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateOfLoss() {
        return dateOfLoss;
    }

    public Claimant dateOfLoss(ZonedDateTime dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
        return this;
    }

    public void setDateOfLoss(ZonedDateTime dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getFactsOfLoss() {
        return factsOfLoss;
    }

    public Claimant factsOfLoss(String factsOfLoss) {
        this.factsOfLoss = factsOfLoss;
        return this;
    }

    public void setFactsOfLoss(String factsOfLoss) {
        this.factsOfLoss = factsOfLoss;
    }

    public String getComments() {
        return comments;
    }

    public Claimant comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Claim getClaim() {
        return claim;
    }

    public Claimant claim(Claim claim) {
        this.claim = claim;
        return this;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Claimant claimant = (Claimant) o;
        if (claimant.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, claimant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Claimant{" +
            "id=" + id +
            ", dateOfLoss='" + dateOfLoss + "'" +
            ", factsOfLoss='" + factsOfLoss + "'" +
            ", comments='" + comments + "'" +
            '}';
    }
}
