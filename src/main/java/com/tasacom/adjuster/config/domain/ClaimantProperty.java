package com.tasacom.iadjuster.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A ClaimantProperty.
 */
@Entity
//@Table(name = "claimant_property")
@DiscriminatorValue("ClaimantProperty")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ClaimantProperty extends Claimant implements Serializable {

    private static final long serialVersionUID = 1L;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Column(name = "place_of_loss")
    private String placeOfLoss;

    @Column(name = "type")
    private String type;

    @Column(name = "loss_type")
    private String lossType;

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public ClaimantProperty(Long id, ZonedDateTime dateOfLoss, String factsOfLoss, String comments) {
        super();
        this.id = id;
        this.dateOfLoss = dateOfLoss;
        this.factsOfLoss = factsOfLoss;
        this.comments = comments;
    }

    public ClaimantProperty() {
    }

    public String getPlaceOfLoss() {
        return placeOfLoss;
    }

    public ClaimantProperty placeOfLoss(String placeOfLoss) {
        this.placeOfLoss = placeOfLoss;
        return this;
    }

    public void setPlaceOfLoss(String placeOfLoss) {
        this.placeOfLoss = placeOfLoss;
    }

    public String getType() {
        return type;
    }

    public ClaimantProperty type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLossType() {
        return lossType;
    }

    public ClaimantProperty lossType(String lossType) {
        this.lossType = lossType;
        return this;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClaimantProperty claimantProperty = (ClaimantProperty) o;
        if (claimantProperty.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, claimantProperty.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ClaimantProperty{" +
            "id=" + id +
            ", placeOfLoss='" + placeOfLoss + "'" +
            ", type='" + type + "'" +
            ", lossType='" + lossType + "'" +
            '}';
    }
}
