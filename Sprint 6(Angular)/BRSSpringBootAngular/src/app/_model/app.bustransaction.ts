/* author Aditya
Created on: 19/10/2019
Last modified on: 23/10/2019
 */

import { Bus } from "./app.bus";

export class BusTransaction{
    transactionId:number;
    date:Date;
    bus:Bus;
    availableSeats:number;
    deleteFlag:number;
}