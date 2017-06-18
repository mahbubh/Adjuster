import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { IadjusterInsuredVehicleModule } from './insured-vehicle/insured-vehicle.module';
import { IadjusterClaimantVehicleModule } from './claimant-vehicle/claimant-vehicle.module';
import { IadjusterInsuredPropertyModule } from './insured-property/insured-property.module';
import { IadjusterClaimantPropertyModule } from './claimant-property/claimant-property.module';
import { IadjusterClaimModule } from './claim/claim.module';
import { IadjusterClaimantModule } from './claimant/claimant.module';
import { IadjusterInsuredModule } from './insured/insured.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        IadjusterInsuredVehicleModule,
        IadjusterClaimantVehicleModule,
        IadjusterInsuredPropertyModule,
        IadjusterClaimantPropertyModule,
        IadjusterClaimModule,
        IadjusterClaimantModule,
        IadjusterInsuredModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IadjusterEntityModule {}
