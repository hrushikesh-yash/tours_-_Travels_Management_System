import { formatDate } from "@angular/common";
import { CityRoutes } from "./CityRoutes";
import { User } from "./masterUser";
import { Status } from "./Status";
import { Tour } from "./Tour";
import { Vehicle } from "./Vehicle";

export class BookingHistory{

    bookingHistoryId:number=0;
    user:User;
    vehicle:Vehicle;
    tour:Tour;
    status:Status;
    cityRoute:CityRoutes;
    bookingDate:Date=new Date(formatDate(new Date(), 'yyyy/MM/dd','en'));
    travelStartDate:Date= new Date(formatDate(new Date(), 'yyyy/MM/dd','en'));
    travelEndDate:Date= new Date(formatDate(new Date(), 'yyyy/MM/dd','en'));
    travelAmount:number=0;
}