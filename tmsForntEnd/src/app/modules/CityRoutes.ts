import { City } from "./City";

export class CityRoutes{
    routeId:number  = 0;
    routeName:string = "";
    sourceCity:City;
    destinationCity:City;
    routeCreatedDate:Date = new Date();
    routePrice:number=0;
    routeIsDeleted:number=0;
}