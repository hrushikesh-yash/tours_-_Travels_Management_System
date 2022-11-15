import { City } from "./City";

export class CityRoutes{
    routeId:number  = 0;
    routeName:string = "";
    sourceCity:City;
    destinationCity:City;
    routeCreatedDate:Date = new Date();
    routeIsDeleted:number=0;
}