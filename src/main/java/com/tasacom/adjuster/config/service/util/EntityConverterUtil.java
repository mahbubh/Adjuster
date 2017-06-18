package com.tasacom.iadjuster.service.util;

import com.tasacom.iadjuster.domain.*;
import com.tasacom.iadjuster.web.rest.vm.*;

/**
 * Created by fares on 3/14/17.
 */
public class EntityConverterUtil {
    public static Claimant convertToClaiment(ClaimantVM claimantVM){
        Claimant claimant = null;
        if(claimantVM instanceof ClaimantPropertyVM){
            ClaimantPropertyVM vm = (ClaimantPropertyVM) claimantVM;
            claimant = new ClaimantProperty(
                    claimantVM.getId()
                    , claimantVM.getDateOfLoss()
                    , claimantVM.getFactsOfLoss()
                    , claimantVM.getComments())
                    .placeOfLoss(vm.getPlaceOfLoss())
                    .type(vm.getType())
                    .lossType(vm.getLossType())
            ;
        }
        if(claimantVM instanceof ClaimantVehicleVM){
            ClaimantVehicleVM claimantVehicle = (ClaimantVehicleVM) claimantVM;
            claimant = new ClaimantVehicle(claimantVM.getId()
                    , claimantVM.getDateOfLoss()
                    , claimantVM.getFactsOfLoss()
                    , claimantVM.getComments())
                    .firstName(claimantVehicle.getFirstName())
                    .lastName( claimantVehicle.getLastName())
                    .middleName(claimantVehicle.getMiddleName())
                    .homePhone(claimantVehicle.getHomePhone())
                    .mobilePhone (claimantVehicle.getMobilePhone())
                    .businessPhone (claimantVehicle.getBusinessPhone())
                    .email (claimantVehicle.getEmail())
                    .vin ( claimantVehicle.getVin())
                    .year (claimantVehicle.getYear())
                    .make ( claimantVehicle.getMake())
                    .model ( claimantVehicle.getModel())
                    .subModel ( claimantVehicle.getSubModel())
                    .productionDate ( claimantVehicle.getProductionDate())
                    .color ( claimantVehicle.getColor())
                    .licensePlate ( claimantVehicle.getLicensePlate())
                    .licensePlateExpirationDate ( claimantVehicle.getLicensePlateExpirationDate())
                    .odometer ( claimantVehicle.getOdometer())
            ;
        }

        return claimant;
    }

    public static Insured convertToInsured(InsuredVM insuredVM){
        Insured insured = null;
        if(insuredVM instanceof InsuredPropertyVM){
            InsuredPropertyVM insuredPropertyVM = (InsuredPropertyVM) insuredVM;

            insured = new InsuredProperty(insuredVM.getId(), insuredVM.getDateOfLoss(),
                    insuredVM.getFactsOfLoss(), insuredVM.getComments(),
                    insuredVM.getInsuredCoverageStrip(), null)
                    .lossTypeProperty(insuredPropertyVM.getLossTypeProperty())
                    .typeOfProperty(insuredPropertyVM.getTypeOfProperty())
                    .propertyStreetAddress(insuredPropertyVM.getPropertyStreetAddress())
                    .propertyCity(insuredPropertyVM.getPropertyCity())
                    .propertyState(insuredPropertyVM.getPropertyState())
                    .propertyZip(insuredPropertyVM.getPropertyZip());
        }
        if(insuredVM instanceof InsuredVehicleVM){
            InsuredVehicleVM vm = (InsuredVehicleVM) insuredVM;

            insured = new InsuredVehicle(insuredVM.getId(), insuredVM.getDateOfLoss(),
                    insuredVM.getFactsOfLoss(), insuredVM.getComments(),
                    insuredVM.getInsuredCoverageStrip(), null)
                    .insuredTypesOfLoss(vm.getInsuredTypesOfLoss())
                    .typeOfVehicle(vm.getTypeOfVehicle() )
                    .vin(vm.getVin() )
                    .year(vm.getYear() )
                    .make(vm.getMake() )
                    .model(vm.getModel() )
                    .subModel(vm.getSubModel() )
                    .productionDate(vm.getProductionDate() )
                    .color(vm.getColor() )
                    .licensePlate(vm.getLicensePlate() )
                    .licensePlateExpirationDate(vm.getLicensePlateExpirationDate() )
                    .odometer(vm.getOdometer() )
                    .streetAddress(vm.getStreetAddress() )
                    .state(vm.getState() )
                    .zip(vm.getZip() );
        }
        return insured;
    }

    public static Claim convertToClaim(ClaimVM claimVM){
        Claim claim = new Claim()
                .policyNumber(claimVM.getPolicyNumber())
                .policyExpirationDate(claimVM.getPolicyExpirationDate())
                .claimNumber(claimVM.getClaimNumber())
                .claimRepresentative(claimVM.getClaimRepresentative())
                .claimRepresentativePhone(claimVM.getClaimRepresentativePhone())
                .dateOfLoss(claimVM.getDateOfLoss())
                .factsOfLoss(claimVM.getFactsOfLoss())
                .firstName(claimVM.getFirstName())
                .lastName(claimVM.getLastName())
                .middleName(claimVM.getMiddleName())
                .homePhone(claimVM.getHomePhone())
                .mobilePhone(claimVM.getMobilePhone())
                .businessPhone(claimVM.getBusinessPhone())
                .email(claimVM.getEmail())
                .streetAddress(claimVM.getStreetAddress())
                .city(claimVM.getCity())
                .state(claimVM.getState())
                .zip(claimVM.getZip())
                .comments(claimVM.getComments())
                .insuranceAgentName(claimVM.getInsuranceAgentName())
                .insuranceAgentPhone(claimVM.getInsuranceAgentPhone());

        if(claimVM.getInsured() != null){
            Insured insured = convertToInsured(claimVM.getInsured());
            //insured.setClaim(claim);
            claim.setInsured(insured);
        }
        if (claimVM.getClaimants() != null && claimVM.getClaimants().size() > 0){
            for ( ClaimantVM claimantVM : claimVM.getClaimants()) {
                Claimant claimant = convertToClaiment(claimantVM);
                //claimant.setClaim(claim);
                claim.addClaimant(claimant);
            }
        }
        return claim;
    }
}
