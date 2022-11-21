import { Actor } from "./Admin";

export class User {
    userId:number;
    actor:Actor;
    firstName:string="";
    lastName:string="";
    userName:string="";
    password:string="";
    emailId:string="";
    mobileNo:number=0;
    address:string="";
    gender:string="";
 
    useIsDeleted:number=0;
}