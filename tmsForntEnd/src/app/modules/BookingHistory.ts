export class BookingHistory{

    bookingHistoryId:number=0;
    userId:number;
    vehicleId:number=0;
    tourId:number;
    statusId:number=1;
    bookingDate:Date=new Date();
    travelStartDate:Date= new Date();
    travelEndDate:Date= new Date();
    travelAmount:number=0;
}