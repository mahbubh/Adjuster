package com.tasacom.iadjuster.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Claim.
 */
@Entity
@Table(name = "claim")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Claim implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_number")
    private String policyNumber;

    @Column(name = "policy_expiration_date")
    private ZonedDateTime policyExpirationDate;

    @NotNull
    @Column(name = "claim_number", nullable = false)
    private String claimNumber;

    @NotNull
    @Column(name = "claim_representative", nullable = false)
    private String claimRepresentative;

    @Column(name = "claim_representative_phone")
    private String claimRepresentativePhone;

    @Column(name = "date_of_loss")
    private ZonedDateTime dateOfLoss;

    @Column(name = "facts_of_loss")
    private String factsOfLoss;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @NotNull
    @Column(name = "home_phone", nullable = false)
    private String homePhone;

    @NotNull
    @Column(name = "mobile_phone", nullable = false)
    private String mobilePhone;

    @Column(name = "business_phone")
    private String businessPhone;

    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "street_address", nullable = false)
    private String streetAddress;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "state", nullable = false)
    private String state;

    @NotNull
    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "comments")
    private String comments;

    @Column(name = "insurance_agent_name")
    private String insuranceAgentName;

    @Column(name = "insurance_agent_phone")
    private String insuranceAgentPhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Insured insured;

    @OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Claimant> claimants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Claim policyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
        return this;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public ZonedDateTime getPolicyExpirationDate() {
        return policyExpirationDate;
    }

    public Claim policyExpirationDate(ZonedDateTime policyExpirationDate) {
        this.policyExpirationDate = policyExpirationDate;
        return this;
    }

    public void setPolicyExpirationDate(ZonedDateTime policyExpirationDate) {
        this.policyExpirationDate = policyExpirationDate;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public Claim claimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
        return this;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimRepresentative() {
        return claimRepresentative;
    }

    public Claim claimRepresentative(String claimRepresentative) {
        this.claimRepresentative = claimRepresentative;
        return this;
    }

    public void setClaimRepresentative(String claimRepresentative) {
        this.claimRepresentative = claimRepresentative;
    }

    public String getClaimRepresentativePhone() {
        return claimRepresentativePhone;
    }

    public Claim claimRepresentativePhone(String claimRepresentativePhone) {
        this.claimRepresentativePhone = claimRepresentativePhone;
        return this;
    }

    public void setClaimRepresentativePhone(String claimRepresentativePhone) {
        this.claimRepresentativePhone = claimRepresentativePhone;
    }

    public ZonedDateTime getDateOfLoss() {
        return dateOfLoss;
    }

    public Claim dateOfLoss(ZonedDateTime dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
        return this;
    }

    public void setDateOfLoss(ZonedDateTime dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getFactsOfLoss() {
        return factsOfLoss;
    }

    public Claim factsOfLoss(String factsOfLoss) {
        this.factsOfLoss = factsOfLoss;
        return this;
    }

    public void setFactsOfLoss(String factsOfLoss) {
        this.factsOfLoss = factsOfLoss;
    }

    public String getFirstName() {
        return firstName;
    }

    public Claim firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Claim lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Claim middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public Claim homePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Claim mobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public Claim businessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
        return this;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getEmail() {
        return email;
    }

    public Claim email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public Claim streetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public Claim city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public Claim state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public Claim zip(String zip) {
        this.zip = zip;
        return this;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getComments() {
        return comments;
    }

    public Claim comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInsuranceAgentName() {
        return insuranceAgentName;
    }

    public Claim insuranceAgentName(String insuranceAgentName) {
        this.insuranceAgentName = insuranceAgentName;
        return this;
    }

    public void setInsuranceAgentName(String insuranceAgentName) {
        this.insuranceAgentName = insuranceAgentName;
    }

    public String getInsuranceAgentPhone() {
        return insuranceAgentPhone;
    }

    public Claim insuranceAgentPhone(String insuranceAgentPhone) {
        this.insuranceAgentPhone = insuranceAgentPhone;
        return this;
    }

    public void setInsuranceAgentPhone(String insuranceAgentPhone) {
        this.insuranceAgentPhone = insuranceAgentPhone;
    }

    public Insured getInsured() {
        return insured;
    }

    public Claim insured(Insured insured) {
        this.insured = insured;
        return this;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Set<Claimant> getClaimants() {
        return claimants;
    }

    public Claim claimants(Set<Claimant> claimants) {
        this.claimants = claimants;
        return this;
    }

    public Claim addClaimant(Claimant claimant) {
        this.claimants.add(claimant);
        claimant.setClaim(this);
        return this;
    }

    public Claim removeClaimant(Claimant claimant) {
        this.claimants.remove(claimant);
        claimant.setClaim(null);
        return this;
    }

    public void setClaimants(Set<Claimant> claimants) {
        this.claimants = claimants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Claim claim = (Claim) o;
        if (claim.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, claim.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Claim{" +
            "id=" + id +
            ", policyNumber='" + policyNumber + "'" +
            ", policyExpirationDate='" + policyExpirationDate + "'" +
            ", claimNumber='" + claimNumber + "'" +
            ", claimRepresentative='" + claimRepresentative + "'" +
            ", claimRepresentativePhone='" + claimRepresentativePhone + "'" +
            ", dateOfLoss='" + dateOfLoss + "'" +
            ", factsOfLoss='" + factsOfLoss + "'" +
            ", firstName='" + firstName + "'" +
            ", lastName='" + lastName + "'" +
            ", middleName='" + middleName + "'" +
            ", homePhone='" + homePhone + "'" +
            ", mobilePhone='" + mobilePhone + "'" +
            ", businessPhone='" + businessPhone + "'" +
            ", email='" + email + "'" +
            ", streetAddress='" + streetAddress + "'" +
            ", city='" + city + "'" +
            ", state='" + state + "'" +
            ", zip='" + zip + "'" +
            ", comments='" + comments + "'" +
            ", insuranceAgentName='" + insuranceAgentName + "'" +
            ", insuranceAgentPhone='" + insuranceAgentPhone + "'" +
            '}';
    }
}
