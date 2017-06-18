package com.tasacom.iadjuster.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A ClaimantVehicle.
 */
@Entity
//@Table(name = "claimant_vehicle")
@DiscriminatorValue("ClaimantVehicle")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ClaimantVehicle extends Claimant implements Serializable {

    private static final long serialVersionUID = 1L;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "business_phone")
    private String businessPhone;

    @Column(name = "email")
    private String email;

    @Column(name = "vin")
    private String vin;

    @Column(name = "year")
    private String year;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "sub_model")
    private String subModel;

    @Column(name = "production_date")
    private String productionDate;

    @Column(name = "color")
    private String color;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "license_plate_expiration_date")
    private String licensePlateExpirationDate;

    @Column(name = "odometer")
    private String odometer;

    public ClaimantVehicle() {
        super();
    }

    public ClaimantVehicle(Long id, ZonedDateTime dateOfLoss, String factsOfLoss, String comments) {
        super();
        this.id = id;
        this.dateOfLoss = dateOfLoss;
        this.factsOfLoss = factsOfLoss;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public ClaimantVehicle firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ClaimantVehicle lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public ClaimantVehicle middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ClaimantVehicle homePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ClaimantVehicle mobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public ClaimantVehicle businessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
        return this;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getEmail() {
        return email;
    }

    public ClaimantVehicle email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVin() {
        return vin;
    }

    public ClaimantVehicle vin(String vin) {
        this.vin = vin;
        return this;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getYear() {
        return year;
    }

    public ClaimantVehicle year(String year) {
        this.year = year;
        return this;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public ClaimantVehicle make(String make) {
        this.make = make;
        return this;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public ClaimantVehicle model(String model) {
        this.model = model;
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSubModel() {
        return subModel;
    }

    public ClaimantVehicle subModel(String subModel) {
        this.subModel = subModel;
        return this;
    }

    public void setSubModel(String subModel) {
        this.subModel = subModel;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public ClaimantVehicle productionDate(String productionDate) {
        this.productionDate = productionDate;
        return this;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getColor() {
        return color;
    }

    public ClaimantVehicle color(String color) {
        this.color = color;
        return this;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public ClaimantVehicle licensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlateExpirationDate() {
        return licensePlateExpirationDate;
    }

    public ClaimantVehicle licensePlateExpirationDate(String licensePlateExpirationDate) {
        this.licensePlateExpirationDate = licensePlateExpirationDate;
        return this;
    }

    public void setLicensePlateExpirationDate(String licensePlateExpirationDate) {
        this.licensePlateExpirationDate = licensePlateExpirationDate;
    }

    public String getOdometer() {
        return odometer;
    }

    public ClaimantVehicle odometer(String odometer) {
        this.odometer = odometer;
        return this;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClaimantVehicle claimantVehicle = (ClaimantVehicle) o;
        if (claimantVehicle.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, claimantVehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ClaimantVehicle{" +
            "id=" + id +
            ", firstName='" + firstName + "'" +
            ", lastName='" + lastName + "'" +
            ", middleName='" + middleName + "'" +
            ", homePhone='" + homePhone + "'" +
            ", mobilePhone='" + mobilePhone + "'" +
            ", businessPhone='" + businessPhone + "'" +
            ", email='" + email + "'" +
            ", vin='" + vin + "'" +
            ", year='" + year + "'" +
            ", make='" + make + "'" +
            ", model='" + model + "'" +
            ", subModel='" + subModel + "'" +
            ", productionDate='" + productionDate + "'" +
            ", color='" + color + "'" +
            ", licensePlate='" + licensePlate + "'" +
            ", licensePlateExpirationDate='" + licensePlateExpirationDate + "'" +
            ", odometer='" + odometer + "'" +
            '}';
    }
}
