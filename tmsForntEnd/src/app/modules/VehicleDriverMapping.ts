import { Route } from "@angular/router";
import { CityRoutes } from "./CityRoutes";
import { User } from "./masterUser";
import { Vehicle } from "./Vehicle";

export class VehicleDriverMapping{
    mappingVehicleDriverDetailsId:number;
    vehicle:Vehicle;
    driver:User;
    route:CityRoutes;
    vehicleDriverAssignDate:Date;
    vehicleFare:number;
    mappingVehicleDriverIsDeleted:number=0;

}