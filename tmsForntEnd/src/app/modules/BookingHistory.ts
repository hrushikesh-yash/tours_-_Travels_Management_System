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
    bookingDate:Date=new Date();
    travelStartDate:Date= new Date();
    travelEndDate:Date= new Date();
    travelAmount:number=0;
}