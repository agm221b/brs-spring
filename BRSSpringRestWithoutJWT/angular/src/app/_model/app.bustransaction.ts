import { Bus } from "./app.bus";

export class BusTransaction{
    transactionId:number;
    date:Date;
    bus:Bus;
    availableSeats:number;
    deleteFlag:number;
}