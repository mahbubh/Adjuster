package com.tasacom.iadjuster.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Insured.
 */
@Entity
@Table(name = "insured")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="insured_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="insuredType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = InsuredProperty.class, name = "property"),
        @JsonSubTypes.Type(value = InsuredVehicle.class, name = "vehicle")
})
public abstract class Insured implements Serializable {

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

    @Column(name = "insured_coverage_strip")
    protected String insuredCoverageStrip;

    @OneToOne(mappedBy = "insured")
    @JsonIgnore
    protected Claim claim;

    public Insured() {
    }

    public Insured(Long id, ZonedDateTime dateOfLoss, String factsOfLoss, String comments, String insuredCoverageStrip, Claim claim) {
        this.id = id;
        this.dateOfLoss = dateOfLoss;
        this.factsOfLoss = factsOfLoss;
        this.comments = comments;
        this.insuredCoverageStrip = insuredCoverageStrip;
        this.claim = claim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateOfLoss() {
        return dateOfLoss;
    }

    public Insured dateOfLoss(ZonedDateTime dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
        return this;
    }

    public void setDateOfLoss(ZonedDateTime dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getFactsOfLoss() {
        return factsOfLoss;
    }

    public Insured factsOfLoss(String factsOfLoss) {
        this.factsOfLoss = factsOfLoss;
        return this;
    }

    public void setFactsOfLoss(String factsOfLoss) {
        this.factsOfLoss = factsOfLoss;
    }

    public String getComments() {
        return comments;
    }

    public Insured comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInsuredCoverageStrip() {
        return insuredCoverageStrip;
    }

    public Insured insuredCoverageStrip(String insuredCoverageStrip) {
        this.insuredCoverageStrip = insuredCoverageStrip;
        return this;
    }

    public void setInsuredCoverageStrip(String insuredCoverageStrip) {
        this.insuredCoverageStrip = insuredCoverageStrip;
    }

    public Claim getClaim() {
        return claim;
    }

    public Insured claim(Claim claim) {
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
        Insured insured = (Insured) o;
        if (insured.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, insured.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Insured{" +
            "id=" + id +
            ", dateOfLoss='" + dateOfLoss + "'" +
            ", factsOfLoss='" + factsOfLoss + "'" +
            ", comments='" + comments + "'" +
            ", insuredCoverageStrip='" + insuredCoverageStrip + "'" +
            '}';
    }
}
